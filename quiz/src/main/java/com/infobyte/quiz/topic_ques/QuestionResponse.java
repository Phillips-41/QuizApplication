package com.infobyte.quiz.topic_ques;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private Integer id;
    private String title;
    private List<OptionResponse> options;
}
