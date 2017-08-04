package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.InputType;

public interface PublicDataAPIResponseParser {
    void parse(InputType type, String input);
    boolean hasError();
    PublicDataAPIResult getResult();
}
