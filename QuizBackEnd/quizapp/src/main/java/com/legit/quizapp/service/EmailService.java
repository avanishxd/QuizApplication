package com.legit.quizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendQuizReport(int score) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("avanishmore25@gmail.com");
        message.setText("Thank you for submitting the Test!\nYour Score: "+score);
        message.setSubject("Test Result");

        mailSender.send(message);
        System.out.println("Mail Sent Successfully..........");
    }

}
