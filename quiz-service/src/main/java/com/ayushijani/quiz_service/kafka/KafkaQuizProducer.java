package com.ayushijani.quiz_service.kafka;



import com.ayushijani.quiz_service.model.QuizResultEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaQuizProducer {

    @Autowired
    private KafkaTemplate<String, QuizResultEvent> kafkaTemplate;

    private final String TOPIC = "quiz-submitted";

    public void sendQuizResult(QuizResultEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}


