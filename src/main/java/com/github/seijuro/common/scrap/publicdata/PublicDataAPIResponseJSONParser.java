package com.github.seijuro.common.scrap.publicdata;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class PublicDataAPIResponseJSONParser implements PublicDataAPIResponseParser {
    /**
     * enum - Input Type
     */
    public enum InputType {
        UNKNOWN(InputType.CODE_INPUTTYPE_UNKNOWN),
        FILE(InputType.CODE_INPUTTYPE_FILE),
        TEXT(InputType.CODE_INPUTTYPE_TEXT);

        static final int CODE_INPUTTYPE_UNKNOWN = -1;
        static final int CODE_INPUTTYPE_TEXT = 1;
        static final int CODE_INPUTTYPE_FILE = 2;

        /**
         * Instance Property
         */
        private final int code;

        /**
         * C'tor
         *
         * @param $code
         */
        InputType(int $code) {
            this.code = $code;
        }
    }

    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PROTECTED)
    private final InputType inputType;
    @Getter(AccessLevel.PROTECTED)
    private final String input;

    @Setter(AccessLevel.PROTECTED)
    private boolean hasError = false;

    //  final result
    @Setter(AccessLevel.PROTECTED)
    private PublicDataAPIResult result = null;

    /**
     * C'tor
     *
     * @param type
     * @param input
     */
    protected PublicDataAPIResponseJSONParser(InputType type, String input) {
        this.inputType = type;
        this.input = input;
    }

    @Override
    public boolean hasError() {
        return this.hasError;
    }

    @Override
    public PublicDataAPIResult getResult() {
        return this.result;
    }

    @Override
    public void parse() {
    }
}
