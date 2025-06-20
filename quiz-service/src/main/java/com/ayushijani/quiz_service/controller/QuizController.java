package com.ayushijani.quiz_service.controller;

import com.ayushijani.quiz_service.model.QuestionWrapper;
import com.ayushijani.quiz_service.model.QuizDto;
import com.ayushijani.quiz_service.model.Response;
import com.ayushijani.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

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
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }


}
