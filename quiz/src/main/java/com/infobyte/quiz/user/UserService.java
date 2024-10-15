package com.infobyte.quiz.user;

import com.infobyte.quiz.handler.NoUnansweredQuestionsException;
import com.infobyte.quiz.topic_ques.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final TopicRepository topicRepository;
    private final OptionsRepository optionsRepository;
    private final UserAttemptRepository userAttemptRepository;
    private final UserQuizSummaryRepository userQuizSummaryRepository;

    public QuestionResponse retrieveQuestion(Integer topicId, Authentication connectedUser) {
        User user=((User) connectedUser.getPrincipal());
        List<Question> unansweredQuestions = questionRepository.findUnansweredQuestionsByTopicAndUser(topicId, user.getId());
        if (!unansweredQuestions.isEmpty()) {
            Question question = unansweredQuestions.get(0);
            QuestionResponse questionResponse = questionMapper.toQuestionResponse(question);
            return questionResponse;}else{
            throw new NoUnansweredQuestionsException("No unanswered questions found for the given topic and user.");
        }
    }

    public List<TopicResponse> retrieveTopics() {
       return topicRepository.findAll().stream()
                .map(topic->
                    TopicResponse.builder()
                            .topicId(topic.getTopicId())
                            .topic(topic.getName())
                            .build())
                .collect(Collectors.toList());
    }

    public boolean submitAnswer(AnswerRequest request, Authentication connectedUser) {
        User user=((User) connectedUser.getPrincipal());
        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Options selectedOption = optionsRepository.findById(request.getSelectedOptionId())
                .orElseThrow(() -> new RuntimeException("Option not found"));
        Options correctOption = optionsRepository.findCorrectOptionByQuestionId(request.getQuestionId());
        boolean isCorrect = selectedOption.equals(correctOption);

        UserAttempt userAttempt = UserAttempt.builder()
                .user(user)
                .topic(question.getTopic())
                .question(question)
                .selectedOption(selectedOption)
                .isCorrect(isCorrect)
                .build();
         userAttemptRepository.save(userAttempt);
         return isCorrect;
    }

    public QuizScoreResponse getScore(Integer topicId, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Topic topic = topicRepository.findById(topicId).orElseThrow(()->new EntityNotFoundException("topic is not found with id "+topicId));

        // Get all attempts for the user and topic
        List<UserAttempt> attempts = userAttemptRepository.findByUserIdAndTopic_TopicId(user.getId(), topicId);

        long totalQuestions = attempts.size();
        long correctAnswers = attempts.stream().filter(UserAttempt::getIsCorrect).count();
        long wrongAnswers = totalQuestions - correctAnswers;

        double score = totalQuestions > 0 ? (double) correctAnswers / totalQuestions * 100 : 0.0;

        UserQuizSummary summary=UserQuizSummary.builder()
                .user(user)
                .name(user.getFirstName()+" "+user.getLastName())
                .topic(topic)
                .totalQuestions(totalQuestions)
                .correctAnswers(correctAnswers)
                .score(score)
                .build();
        userQuizSummaryRepository.save(summary);

        return QuizScoreResponse.builder()
                .topicId(topicId)
                .totalQuestions(totalQuestions)
                .correctAnswers(correctAnswers)
                .wrongAnswers(wrongAnswers)
                .score(score)
                .build();
    }

    public List<LeaderResponse> leaderBoard() {
        return userQuizSummaryRepository.findAllUserQuizSummaryByScore();
    }

    public List<PastQuizAttemptResponse> getPastQuizAttempt(Authentication id) {
        User user = (User) id.getPrincipal();
        return  userQuizSummaryRepository.findByUserId(user.getId()).stream()
                .map(response-> PastQuizAttemptResponse.builder()
                        .score(response.getScore())
                        .topic(response.getTopic().getName())
                        .build())
                .collect(Collectors.toList());
    }
}
