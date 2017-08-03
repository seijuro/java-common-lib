package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.IParser;

public interface PublicDataAPIResponseParser extends IParser {
    boolean hasError();
    PublicDataAPIResult getResult();
}
