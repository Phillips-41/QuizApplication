package com.infobyte.quiz.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_CREATE("admin:create");

    @Getter
    private final String permission;
}