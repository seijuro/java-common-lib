package com.github.seijuro.common.scrap.publicdata.runner;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPI;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIException;

interface IPublicDataAPIRunnable<T extends PublicDataAPI> extends Runnable {
    public abstract T getAPI() throws PublicDataAPIException;
    public boolean request();
    public abstract void shutdown();
}
