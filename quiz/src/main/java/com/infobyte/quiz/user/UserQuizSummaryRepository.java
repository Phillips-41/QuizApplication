package com.infobyte.quiz.user;

import com.infobyte.quiz.topic_ques.PastQuizAttemptResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserQuizSummaryRepository extends JpaRepository<UserQuizSummary,Integer> {
    @Query("""
        SELECT new com.infobyte.quiz.user.LeaderResponse(u.user.id, u.user.firstName, AVG(u.score))
        FROM UserQuizSummary u
        GROUP BY u.user.id, u.user.firstName
        ORDER BY AVG(u.score) DESC
        """)
    List<LeaderResponse> findAllUserQuizSummaryByScore();

    List<UserQuizSummary> findByUserId(Integer id);
}
