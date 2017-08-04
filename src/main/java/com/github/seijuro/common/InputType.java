package com.github.seijuro.common;

import lombok.AccessLevel;
import lombok.Getter;

public enum InputType {
    UNKNOWN(InputType.CODE_INPUTTYPE_UNKNOWN),
    FILE(InputType.CODE_INPUTTYPE_FILE),
    TEXT(InputType.CODE_INPUTTYPE_TEXT);

    public static final int CODE_INPUTTYPE_UNKNOWN = -1;
    public static final int CODE_INPUTTYPE_TEXT = 1;
    public static final int CODE_INPUTTYPE_FILE = 2;

    /**
     * Instance Property
     */
    @Getter(AccessLevel.PUBLIC)
    private final int code;

    InputType(int $code) {
        this.code = $code;
    }
}