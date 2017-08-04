package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIErrorResult;
import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIResult;

public interface PublicDataAPIResultHandler<T extends PublicDataAPIResult> {
    public abstract boolean handleResults(T result);
    public abstract boolean handleError(PublicDataAPIErrorResult error);
}
