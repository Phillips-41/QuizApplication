package com.infobyte.quiz.user;
import com.infobyte.quiz.topic_ques.Topic;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserQuizSummary {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    private long totalQuestions;
    private long correctAnswers;
    private double score;
}


