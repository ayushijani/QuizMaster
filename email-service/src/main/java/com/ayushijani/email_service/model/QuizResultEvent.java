package com.ayushijani.email_service.model;



import lombok.Data;

import java.time.LocalDateTime;


@Data
public class QuizResultEvent {
    private String username;
    private String email;
    private Long quizId;
    private int score;
    private LocalDateTime timestamp;
}

