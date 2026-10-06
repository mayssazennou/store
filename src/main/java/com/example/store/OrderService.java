package com.example.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// @Service 
public class OrderService {

    PaymentService paymentService;

    // NullPointerException if not autowired
    // public OrderService() {} // default constructor

    // BeanCreationException if not autowired
    // public OrderService(int x) {} // or any other non-default constructor

    // @Autowired 
    // not required for single-constructor beans nowadays
    public OrderService(@Qualifier("stripe") PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    @PostConstruct
    public void init() {
        System.out.println("OrderService PostConstruct");
    }

    @PreDestroy 
    public void cleanup() {
        System.out.println("OrderService PreDestroy");
    }
    
    public void placeOrder() {
        paymentService.processPayment(10);
    }
}
