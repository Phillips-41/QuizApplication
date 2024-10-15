package com.infobyte.quiz.topic_ques;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PastQuizAttemptResponse {
    private double score;
    private String topic;
}
