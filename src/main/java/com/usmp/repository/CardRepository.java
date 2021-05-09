package com.usmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usmp.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer>{
    
}
