package com.infobyte.quiz.handler;

public class NoUnansweredQuestionsException extends RuntimeException {
    public NoUnansweredQuestionsException(String message) {
        super(message);
    }
}
