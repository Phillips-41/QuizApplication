package com.infobyte.quiz.topic_ques;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    @Query("""
       SELECT q FROM Question q
        WHERE q.topic.topicId = :topicId
         AND q.id
         NOT IN (SELECT ua.question.id FROM UserAttempt ua WHERE ua.user.id = :userId)
    """)
    List<Question> findUnansweredQuestionsByTopicAndUser(@Param("topicId") Integer topicId, @Param("userId") Integer userId);

}
