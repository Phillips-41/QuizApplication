package com.infobyte.quiz.user;

import com.infobyte.quiz.handler.NoUnansweredQuestionsException;
import com.infobyte.quiz.topic_ques.AnswerRequest;
import com.infobyte.quiz.topic_ques.PastQuizAttemptResponse;
import com.infobyte.quiz.topic_ques.QuestionResponse;
import com.infobyte.quiz.topic_ques.TopicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
  @GetMapping("/topic/{topicId}/question")
    public ResponseEntity<QuestionResponse> retrieveQuestion(@PathVariable("topicId") Integer id, Authentication connectedUser){
      try {
          QuestionResponse questionResponse = service.retrieveQuestion(id, connectedUser);
          return ResponseEntity.ok(questionResponse);
      } catch (NoUnansweredQuestionsException e) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
  }
  @GetMapping("/topics")
    public ResponseEntity<List<TopicResponse>> Topic(){
      return ResponseEntity.ok(service.retrieveTopics());
  }
  @PostMapping("/answer/submit")
    public ResponseEntity<Boolean> submitAnswer(@RequestBody AnswerRequest request, Authentication connectedUser){
      return ResponseEntity.ok(service.submitAnswer(request,connectedUser));
  }
  @GetMapping("/quiz/score/topic/{topicId}")
    public ResponseEntity<QuizScoreResponse> submitQuiz(@PathVariable("topicId") Integer id,Authentication connectedUser){
      return ResponseEntity.ok(service.getScore(id,connectedUser));
  }
  @GetMapping("/leaderboard")
  public ResponseEntity<List<LeaderResponse>> LeaderBoard(){
    return ResponseEntity.ok(service.leaderBoard());
  }
  @GetMapping("/pastQuizAttempts")
  public ResponseEntity<List<PastQuizAttemptResponse>> getPastQuizAttempt(Authentication id){
    return ResponseEntity.ok(service.getPastQuizAttempt(id));
  }
}
