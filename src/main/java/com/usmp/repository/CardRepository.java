package com.usmp.repository;

import com.usmp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, String> {

    Optional<Card> findByNameLikeAndCardNumberLikeAndExpirationDateLike(String name, String cardNumber, String expirationDate);
    List<Card> findByCardNumberIn(List<String> cardsNumber);

}
