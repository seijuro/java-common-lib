package com.github.seijuro.common.scrap.publicdata.parser;

import com.github.seijuro.common.InputType;
import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIResult;

public interface PublicDataAPIResponseParser {
    public abstract void clear();
    public abstract void parse(InputType type, String input);
    public abstract boolean hasError();
    public abstract PublicDataAPIResult getResult();
}
