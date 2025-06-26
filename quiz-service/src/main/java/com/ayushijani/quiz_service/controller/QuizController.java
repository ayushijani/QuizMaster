package com.ayushijani.quiz_service.controller;

import com.ayushijani.quiz_service.feign.UserInterface;
import com.ayushijani.quiz_service.kafka.KafkaQuizProducer;
import com.ayushijani.quiz_service.model.QuestionWrapper;
import com.ayushijani.quiz_service.model.QuizDto;
import com.ayushijani.quiz_service.model.QuizResultEvent;
import com.ayushijani.quiz_service.model.Response;
import com.ayushijani.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private UserInterface userInterface;

    @Autowired
    private KafkaQuizProducer kafkaQuizProducer;

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());
    }

    @PostMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id,@RequestHeader("X-User-Name") String username,
                                                                  @RequestHeader("X-Roles") String roles)
    {

        System.out.println("User: " + username);
        System.out.println("Roles: " + roles);
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,
                                              @RequestBody List<Response> responses,
                                              @RequestHeader("X-User-Name") String username) {

        // 1. Calculate score
        int score = quizService.calculateResult(id, responses).getBody();

        // 2. Fetch user email via Feign
        var userDto = userInterface.getUserByUsername(username);

        // 3. Create Kafka Event
        QuizResultEvent event = new QuizResultEvent();
        event.setUsername(username);
        event.setEmail(userDto.getEmail());
        event.setQuizId((long) id);
        event.setScore(score);
        event.setTimestamp(LocalDateTime.now());

        // 4. Send Kafka message
        kafkaQuizProducer.sendQuizResult(event);

        return ResponseEntity.ok(score);
    }



}
