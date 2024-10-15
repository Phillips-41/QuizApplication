package com.infobyte.quiz.user;

import jakarta.persistence.GeneratedValue;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeaderResponse {
    @GeneratedValue
    private Integer id;
    private String name;
    private double avgScore;
}
