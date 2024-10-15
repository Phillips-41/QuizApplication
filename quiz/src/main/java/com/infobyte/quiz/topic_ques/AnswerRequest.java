package com.infobyte.quiz.topic_ques;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequest {
    private Integer questionId;
    private Integer selectedOptionId;
}
