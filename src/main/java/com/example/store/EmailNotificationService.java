package com.example.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary 
public class EmailNotificationService implements NotificationService {

    @Value("${mail-server.host}")
    private String host;

    @Value("${mail-server.port}")
    private int port;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.printf("Mail server: %s:%d %n", host, port);
        System.out.printf("Sending email notification to %s: %s %n", recipientEmail, message);
    }
}
