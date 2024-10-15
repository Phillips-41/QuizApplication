package com.infobyte.quiz.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService service;

    @PostMapping("/topic")
    public ResponseEntity<Map<String, Object>> createOrUpdateTopic(@RequestBody TopicRequest request) {
        Map<String, Object> response = service.createOrUpdateTopic(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/question/{topicId}")
    public ResponseEntity<Map<String, Object>> createOrUpdateQuestion(@RequestBody QuestionRequest request, @PathVariable("topicId") Integer topicId) {
        Map<String, Object> response = service.createOrUpdateQuestion(request, topicId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/option/{questionId}")
    public ResponseEntity<Map<String, Object>> createOrUpdateOptions(@RequestBody List<OptionRequest> request, @PathVariable("questionId") Integer questionId) {
        Map<String, Object> response = service.createOrUpdateOptions(request, questionId);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/topic/{topicId}")
    public ResponseEntity<Void> deleteTopic(@PathVariable("topicId") Integer topicId) {
        service.deleteTopic(topicId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/question/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable("questionId") Integer questionId) {
        service.deleteQuestion(questionId);
        return ResponseEntity.noContent().build();
    }
}

