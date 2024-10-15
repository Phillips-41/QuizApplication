package com.infobyte.quiz.user;

import com.infobyte.quiz.topic_ques.Options;
import com.infobyte.quiz.topic_ques.Question;
import com.infobyte.quiz.topic_ques.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAttempt {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "selected_option_id")
    private Options selectedOption;

    private Boolean isCorrect;
    private LocalDateTime attemptTime;
}
