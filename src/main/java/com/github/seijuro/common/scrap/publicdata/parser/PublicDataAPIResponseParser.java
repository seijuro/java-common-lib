package com.github.seijuro.common.scrap.publicdata.parser;

import com.github.seijuro.common.InputType;
import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIResult;

public interface PublicDataAPIResponseParser {
    void parse(InputType type, String input);
    boolean hasError();
    PublicDataAPIResult getResult();
}
