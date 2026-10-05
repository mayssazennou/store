package com.example.store;

public class OrderService {

    PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    public void placeOrder() {
        paymentService.processPayment(10);
    }
}
