package com.usmp.repository;

import com.usmp.entity.CustomerCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerCardRepository extends JpaRepository<CustomerCard, String> {

    List<CustomerCard> findByCustomer_Id(Integer customerId);

}
