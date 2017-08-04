package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.InputType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class PublicDataAPIResponseJSONParser implements PublicDataAPIResponseParser {
    /**
     * Instance Properties
     */
    @Setter(AccessLevel.PROTECTED)
    private boolean hasError = false;

    //  final result
    @Setter(AccessLevel.PROTECTED)
    private PublicDataAPIResult result = null;

    /**
     * C'tor
     */
    protected PublicDataAPIResponseJSONParser() {
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
    public void parse(InputType type, String input) {
    }
}
