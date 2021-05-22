package com.usmp.repository;

import com.usmp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, String> {

    @Query(value = "select * from Card c where c.cardNumber like %:cardNumber% and c.expirationDate like %:expirationDate% and c.cvcCode = cvcCode", nativeQuery = true)
    Optional<Card> findByCardNumberAndExpirationDateAndCvcCode(@Param("cardNumber") String cardNumber, @Param("expirationDate") String expirationDate, @Param("cvcCode") Integer cvcCode);

}
