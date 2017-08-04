package com.github.seijuro.common.scrap.publicdata.runner;

import com.github.seijuro.common.InputType;
import com.github.seijuro.common.http.RestfulAPIErrorResponse;
import com.github.seijuro.common.http.RestfulAPIResponse;
import com.github.seijuro.common.scrap.publicdata.*;
import lombok.AccessLevel;
import lombok.Getter;

public class PublicDataAPIRunnable implements IPublicDataAPIRunnable {
    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PROTECTED)
    private final PublicDataAPIServices service;
    @Getter(AccessLevel.PROTECTED)
    private final PublicDataAPIConfig config;
    @Getter(AccessLevel.PROTECTED)
    private final String serviceKey;

    private PublicDataAPI api;
    @Getter(AccessLevel.PROTECTED)
    private PublicDataAPIResponseParser parser;
    @Getter(AccessLevel.PROTECTED)
    private PublicDataAPIResultHandler handler;

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

    /**
     * set handler
     *
     * @param handler
     */
    public void setHandler(PublicDataAPIResultHandler handler) {
        this.handler = handler;
    }

    public PublicDataAPI getAPI() throws PublicDataAPIException {
        return this.api;
    }

    @Override
    public void init() throws PublicDataAPIException {
        this.api = PublicDataAPIFactory.create(getService(), getConfig(), getServiceKey());
        this.parser = PublicDataAPIResponseParserFactory.create(getService());
    }

    @Override
    public void request() {
        try {
            PublicDataAPI api = getAPI();
            assert (api != null);

            RestfulAPIResponse response = api.request();

            if (response instanceof RestfulAPIErrorResponse) {
                //  TODO handle error ...
            }
            else {
                this.parser.parse(InputType.TEXT, response.getResponse());

                if (this.parser.hasError()) {
                    PublicDataAPIResult reslut = this.parser.getResult();
                    this.handler.handleResults(reslut);
                }
                else {
                    PublicDataAPIErrorResult result = (PublicDataAPIErrorResult)this.parser.getResult();
                    this.handler.handleError(result);
                }
            }
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }
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
