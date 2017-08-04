package com.github.seijuro.common.scrap.publicdata;

public interface IPublicDataAPIResultHandler<T extends PublicDataAPIResult> {
    public abstract boolean handleResults(T result);
    public abstract boolean handleError(PublicDataAPIErrorResult error);
}
