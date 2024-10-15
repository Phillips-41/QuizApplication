package com.infobyte.quiz.admin;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionRequest {
    private Integer id;
    private String optionText;
    private boolean isCorrect;
}
