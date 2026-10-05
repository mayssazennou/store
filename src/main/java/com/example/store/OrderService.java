package com.example.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service 
public class OrderService {

    PaymentService paymentService;

    // NullPointerException if not autowired
    // public OrderService() {} // default constructor

    // BeanCreationException if not autowired
    // public OrderService(int x) {} // or any other non-default constructor

    // @Autowired 
    // not required for single-constructor beans nowadays
    public OrderService(@Qualifier("paypal") PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    public void placeOrder() {
        paymentService.processPayment(10);
    }
}
