package com.github.seijuro.common.scrap.publicdata;

public interface PublicDataAPIResponseParser {
    void parse();
    boolean hasError();
    PublicDataAPIResult getResult();
}
