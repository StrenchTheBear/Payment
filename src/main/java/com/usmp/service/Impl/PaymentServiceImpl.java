package com.usmp.service.Impl;

import com.usmp.entity.Payment;
import com.usmp.repository.PaymentRepository;
import com.usmp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;

    @Override
    public void registerPayment(Payment payment) {
        this.paymentRepository.save(payment);
    }

    @Autowired
    public void setPaymentRepository(PaymentRepository paymentRepository) { this.paymentRepository = paymentRepository; }

}
