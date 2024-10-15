package com.infobyte.quiz.admin;

import com.infobyte.quiz.topic_ques.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final TopicRepository topicRepository;
    private final QuestionRepository questionRepository;
    private final OptionsRepository optionsRepository;

    @Transactional
    public Map<String, Object> createOrUpdateTopic(TopicRequest request) {
        Topic topic;
        String status = "created";

        if (request.getId() != null) {
            topic = topicRepository.findById(request.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Topic not found with this id :: " + request.getId()));
            status = "updated";
        } else {
            topic = Topic.builder()
                    .name(request.getName())
                    .build();
        }
        topic.setName(request.getName());
        topicRepository.save(topic);

        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("topic", topic);
        return response;
    }

    @Transactional
    public Map<String, Object> createOrUpdateQuestion(QuestionRequest request, Integer topicId) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with this id :: " + topicId));

        Question question;
        String status = "created";

        if (request.getId() != null) {
            question = questionRepository.findById(request.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Question not found with this id :: " + request.getId()));
            status = "updated";
        } else {
            question = Question.builder()
                    .title(request.getTitle())
                    .topic(topic)
                    .build();
        }
        question.setTitle(request.getTitle());
        questionRepository.save(question);

        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("question", question);
        return response;
    }

    @Transactional
    public Map<String, Object> createOrUpdateOptions(List<OptionRequest> request, Integer questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with this id :: " + questionId));

        List<Options> optionsList = new ArrayList<>();
        String status = "created";

        for (OptionRequest optionRequest : request) {
            Options option;
            if (optionRequest.getId() != null) {
                option = optionsRepository.findById(optionRequest.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Option not found with id :: " + optionRequest.getId()));
                status = "updated";
            } else {
                option = Options.builder()
                        .optionText(optionRequest.getOptionText())
                        .isCorrect(optionRequest.isCorrect())
                        .question(question)
                        .build();
            }
            option.setOptionText(optionRequest.getOptionText());
            option.setCorrect(optionRequest.isCorrect());
            optionsRepository.save(option);
            optionsList.add(option);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("options", optionsList);
        return response;
    }
    @Transactional
    public void deleteTopic(Integer topicId) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with this id :: " + topicId));
        topicRepository.delete(topic);
    }

    @Transactional
    public void deleteQuestion(Integer questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with this id :: " + questionId));
        questionRepository.delete(question);
    }
}
