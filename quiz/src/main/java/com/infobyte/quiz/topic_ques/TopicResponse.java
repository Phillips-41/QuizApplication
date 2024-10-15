package com.infobyte.quiz.topic_ques;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopicResponse {
    private Integer topicId;
    private String topic;
}
