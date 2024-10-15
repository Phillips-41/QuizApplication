package com.infobyte.quiz.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAttemptRepository extends JpaRepository<UserAttempt, Integer> {
    List<UserAttempt> findByUserIdAndTopic_TopicId(Integer userId, Integer topicId);
}

