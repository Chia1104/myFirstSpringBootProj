package com.example.spring_test.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class SendEmail {
    private final JavaMailSender emailSender;

    public SendEmail(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMail(String from, String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        emailSender.send(message);
    }

}
