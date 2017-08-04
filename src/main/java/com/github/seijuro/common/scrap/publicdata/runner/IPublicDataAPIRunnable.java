package com.github.seijuro.common.scrap.publicdata.runner;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIException;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResultHandler;

interface IPublicDataAPIRunnable extends Runnable {
    public abstract void init() throws PublicDataAPIException;
    public abstract void setHandler(PublicDataAPIResultHandler handler);
    public abstract void request();
    public abstract void shutdown();
}
