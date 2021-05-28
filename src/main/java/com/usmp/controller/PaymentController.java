package com.usmp.controller;

import com.usmp.entity.Card;
import com.usmp.entity.Customer;
import com.usmp.entity.CustomerCard;
import com.usmp.entity.dto.CardInfoDTO;
import com.usmp.entity.dto.CustomerDTO;
import com.usmp.entity.dto.ListCardsResponseDTO;
import com.usmp.entity.dto.RegisterCardRequestDTO;
import com.usmp.service.CardService;
import com.usmp.service.CustomerCardService;
import com.usmp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payment-business")
public class PaymentController {

    private static final String DATA_ACCESS_EXCEPTION_MESSAGE = "Ocurrió un error al realizar la operación en la base de datos";

    private CustomerService customerService;
    private CardService cardService;
    private CustomerCardService customerCardService;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomers() {
        return this.customerService.findCustomers();
    }

    @PostMapping("/customers/create")
    public ResponseEntity<?> create(@Valid @RequestBody Customer customer, BindingResult result) {
        Map<String, Object> createCustomerMap = createMap();
        Customer newCustomer = null;

        if(result.hasErrors()) {
            List<String> errors = this.getErros(result);
            createCustomerMap.put("errors", errors);
            return new ResponseEntity<>(createCustomerMap, HttpStatus.BAD_REQUEST);
        }

        try {
            newCustomer = this.customerService.createCustomer(customer);
        } catch (DataAccessException ex) {
            createCustomerMap.put("message", DATA_ACCESS_EXCEPTION_MESSAGE);
            createCustomerMap.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(createCustomerMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        createCustomerMap.put("customer", newCustomer);
        createCustomerMap.put("message", "Tu registro se acaba de realizar con éxito!");
        return new ResponseEntity<>(createCustomerMap, HttpStatus.CREATED);
    }

    @GetMapping("/cards")
    @ResponseStatus(HttpStatus.OK)
    public List<Card> findCards() {
        return this.cardService.findCards();
    }

    @PostMapping("/cards/register")
    public ResponseEntity<?> registerCard(@Valid @RequestBody RegisterCardRequestDTO registerCardRequest, BindingResult result) {

        Map<String, Object> registerCardMap = createMap();

        if(result.hasErrors()) {
            List<String> errors = this.getErros(result);
            registerCardMap.put("errors", errors);
            return new ResponseEntity<>(registerCardMap, HttpStatus.BAD_REQUEST);
        }

         try {
            Card card = this.cardService.findByNameAndCardNumberAndExpirationDate(registerCardRequest.getCardName(),
                    registerCardRequest.getCardNumber(), registerCardRequest.getExpirationDate());
            if(Objects.isNull(card)) {
                registerCardMap.put("message", "Los datos ingresados de la tarjeta no son los correctos.");
                return new ResponseEntity<>(registerCardMap, HttpStatus.NOT_FOUND);
            }

            CustomerCard customerCard = new CustomerCard();
            customerCard.setCardNumber(registerCardRequest.getCardNumber());
            Customer customer = new Customer();
            customer.setId(registerCardRequest.getCustomerId());
            customerCard.setCustomer(customer);

            this.customerCardService.insertCard(customerCard);

            Customer customerFound = this.customerService.findById(registerCardRequest.getCustomerId());

            String hiddenCardNumber = hideCardValue(registerCardRequest.getCardNumber());

            registerCardMap.put("message", "Felicitaciones ".concat(customerFound.getName()).concat(" ").concat(customerFound.getFirstLastName()).
                    concat(" tu tarjeta ").concat(hiddenCardNumber).concat(" fue registrada con éxito"));
            return new ResponseEntity<>(registerCardMap, HttpStatus.CREATED);
         } catch (DataAccessException ex) {
            registerCardMap.put("message", DATA_ACCESS_EXCEPTION_MESSAGE);
            registerCardMap.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(registerCardMap, HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    @GetMapping("/customers/cards/{customerId}")
    public ResponseEntity<?> getCustomerCards(@PathVariable Integer customerId) {
        List<CustomerCard> customerCards = this.customerCardService.findCustomerCards(customerId);

        Map<String, Object> getCustomerCardsMap = createMap();

        if(Objects.isNull(customerCards)) {
            getCustomerCardsMap.put("message", "Aún no tiene ninguna tarjeta registrada en el sistema");
            return new ResponseEntity<>(getCustomerCardsMap, HttpStatus.NO_CONTENT);
        }

        List<String> cardsNumber = customerCards.stream().map(card -> card.getCardNumber()).collect(Collectors.toList());

        List<Card> cards = this.cardService.findCardsByNumbers(cardsNumber);

        ListCardsResponseDTO listCards = new ListCardsResponseDTO();
        listCards.setCustomer(new CustomerDTO(customerCards.get(0).getCustomer().getName(), customerCards.get(0).getCustomer().getFirstLastName()));

        List<CardInfoDTO> cardsInfo = cards.stream().map(element -> new CardInfoDTO(element.getName(), element.getCardNumber())).collect(Collectors.toList());
        listCards.setCards(cardsInfo);

        getCustomerCardsMap.put("message", "Usted tiene ".concat(String.valueOf(customerCards.size())).concat(" tarjetas registradas"));
        getCustomerCardsMap.put("cards", listCards);
        return new ResponseEntity<>(getCustomerCardsMap, HttpStatus.OK);
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Autowired
    public void setCardService(CardService cardService) { this.cardService = cardService; }
    @Autowired
    public void setCustomerCardService(CustomerCardService customerCardService) { this.customerCardService = customerCardService; }

    private Map<String, Object> createMap() { return new HashMap<>(); }

    private List<String> getErros(BindingResult result) {
        return result.getFieldErrors().stream().
                map(field -> "El campo '".concat(field.getField()).concat("' ").concat(field.getDefaultMessage())).collect(Collectors.toList());
    }

    private String hideCardValue(String cardNumber) {
        return "**** **** **** ".concat(cardNumber.substring(12));
    }

}
