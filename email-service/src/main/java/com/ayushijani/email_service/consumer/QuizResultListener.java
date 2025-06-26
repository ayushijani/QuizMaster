package com.ayushijani.email_service.consumer;

import com.ayushijani.email_service.model.QuizResultEvent;
import com.ayushijani.email_service.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class QuizResultListener {

    @Autowired
    private EmailSenderService emailSenderService;

    @KafkaListener(topics = "quiz-submitted", groupId = "email-service-group")
    public void handleQuizSubmission(QuizResultEvent event) {
        System.out.println("📨 Received quiz result for: " + event.getEmail());
        emailSenderService.sendResultEmail(event);
    }
}
