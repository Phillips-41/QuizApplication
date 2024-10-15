package com.infobyte.quiz.topic_ques;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OptionsRepository extends JpaRepository<Options,Integer> {
    @Query("SELECT o FROM Options o WHERE o.question.id = :questionId AND o.isCorrect = true")
    Options findCorrectOptionByQuestionId(Integer questionId);
}
