package com.github.seijuro.common.scrap.publicdata.runner;

import com.github.seijuro.common.http.RestfulAPIResponse;
import com.github.seijuro.common.http.StatusCode;
import com.github.seijuro.common.http.StatusCodeUtils;
import com.github.seijuro.common.scrap.publicdata.*;
import lombok.AccessLevel;
import lombok.Getter;

public abstract class PublicDataAPIRunnable<T extends PublicDataAPI> implements IPublicDataAPIRunnable<T> {
    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PROTECTED)
    private final PublicDataAPIServices service;
    @Getter(AccessLevel.PROTECTED)
    private final PublicDataAPIConfig config;
    @Getter(AccessLevel.PROTECTED)
    private final String serviceKey;

    private T api;
    private IPublicDataAPIResultHandler handler;

    /**
     * C'tor
     *
     * @param $service
     * @param $serviceKey
     */
    public PublicDataAPIRunnable(PublicDataAPIServices $service, PublicDataAPIConfig config, String $serviceKey) {
        this.service = $service;
        this.config = config;
        this.serviceKey = $serviceKey;
    }

    private void createAPIIfNotExists() throws PublicDataAPIException {
        if (this.api == null) {
            this.api = (T) PublicDataAPIFactory.create(getService(), getConfig(), getServiceKey());
        }
    }

    @Override
    public T getAPI() throws PublicDataAPIException {
        createAPIIfNotExists();

        return this.api;
    }

    @Override
    public boolean request() {
        try {
            T api = getAPI();

            RestfulAPIResponse response = api.request();

            int responseCode = response.getHttpResponseCode();
            StatusCode httpStatusCode = StatusCodeUtils.get(responseCode);
            StringBuffer sb = new StringBuffer("HTTP Response -> ");

            if (StatusCodeUtils.isOK(httpStatusCode)) {
                StatusCodeUtils.format(httpStatusCode, sb::append);
            }
            else {
                StatusCodeUtils.format(httpStatusCode, sb::append);
            }

            System.out.println(sb.toString());
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        return false;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public void run() {
        try {

        }
        catch (Exception excp) {
            excp.printStackTrace();
        }
    }
}
