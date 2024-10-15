package com.infobyte.quiz.topic_ques;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topic topic;
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Options> options;
}
