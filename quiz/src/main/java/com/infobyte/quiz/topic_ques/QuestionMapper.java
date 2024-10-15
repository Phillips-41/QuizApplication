package com.infobyte.quiz.topic_ques;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionMapper {
    public QuestionResponse toQuestionResponse(Question question) {
        List<OptionResponse> optionResponses = question.getOptions().stream()
                .map(options ->OptionResponse.builder()
                        .optionId(options.getId())
                        .optionText(options.getOptionText())
                        .isSelected(options.isCorrect())
                        .build() )
                .collect(Collectors.toList());
        return QuestionResponse.builder()
                .id(question.getId())
                .title(question.getTitle())
                .options(optionResponses)
                .build();
    }
}
