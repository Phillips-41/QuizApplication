package com.infobyte.quiz.admin;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    private Integer id;
    private String title;
}
