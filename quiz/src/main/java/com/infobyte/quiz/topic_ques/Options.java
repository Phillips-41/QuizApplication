package com.infobyte.quiz.topic_ques;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Options {
    @Id
    @GeneratedValue
    private Integer id;
    private String optionText;
    private boolean isCorrect;
    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question question;
}
