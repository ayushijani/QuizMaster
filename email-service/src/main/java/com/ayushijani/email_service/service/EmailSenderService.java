package com.ayushijani.email_service.service;

import com.ayushijani.email_service.model.QuizResultEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResultEmail(QuizResultEvent event) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(event.getEmail());
        message.setSubject("Quiz Result - Quiz #" + event.getQuizId());
        message.setText("Hi " + event.getUsername() + ",\n\nYou scored " + event.getScore() + " marks.\n\nThanks for using QuizMaster!");
        mailSender.send(message);
    }
}
