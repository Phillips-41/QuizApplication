package com.infobyte.quiz.admin;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor // Add this
@AllArgsConstructor
public class TopicRequest {
    private Integer id;
    private String name;
}
