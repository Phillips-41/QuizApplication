package com.infobyte.quiz.user;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizScoreResponse {
    private Integer topicId;
    private long totalQuestions;
    private long correctAnswers;
    private long wrongAnswers;
    private double score;
}
