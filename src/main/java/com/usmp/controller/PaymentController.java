package com.usmp.controller;

import com.usmp.entity.Card;
import com.usmp.entity.Customer;
import com.usmp.service.CardService;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payment-business")
public class PaymentController {

    private static final String DATA_ACCESS_EXCEPTION_MESSAGE = "Ocurrió un error al realizar la operación en la base de datos";

    private CustomerService customerService;
    private CardService cardService;

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
            List<String> errors = result.getFieldErrors().stream().
                    map(field -> "El campo '".concat(field.getField()).concat("' ").concat(field.getDefaultMessage())).collect(Collectors.toList());
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

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customer customer) {
        this.customerService.createCustomer(customer);
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Autowired
    public void setCardService(CardService cardService) { this.cardService = cardService; }

    private Map<String, Object> createMap() { return new HashMap<>(); }

}
