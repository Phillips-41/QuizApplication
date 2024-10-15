package com.infobyte.quiz.topic_ques;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic {
    @Id
    @GeneratedValue
    private Integer topicId;
    private String name;
    @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<Question> question;
}
