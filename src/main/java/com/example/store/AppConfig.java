package com.example.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class AppConfig {

    @Value("${payment-gateway:stripe}")
    private String paymentGateway;
    
    @Bean 
    PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean 
    PaymentService paypal() {
        return new PayPalPaymentService();
    }

    @Bean 
    OrderService orderService() {
        if (paymentGateway.equals("stripe")) {
            return new OrderService(stripe());
        }
        return new OrderService(paypal());
    }

}
