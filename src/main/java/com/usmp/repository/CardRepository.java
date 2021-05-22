package com.usmp.repository;

import com.usmp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, String> {

    /*@Query(value = "select * from Card c where c.cardNumber like %:cardNumber% and c.expirationDate like %:expirationDate% and c.cvcCode = :cvcCode", nativeQuery = true)
    Card findByCardNumberAndExpirationDateAndCvcCode(@Param("cardNumber") String cardNumber, @Param("expirationDate") String expirationDate, @Param("cvcCode") Integer cvcCode);*/

    Optional<Card> findByCardNumberLikeAndExpirationDateLikeAndCvcCode(String cardNumber, String expirationDate, Integer cvcCode);

}
