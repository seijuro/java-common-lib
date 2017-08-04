package com.github.seijuro.common.scrap.publicdata.runner;

import com.github.seijuro.common.scrap.publicdata.runner.config.PublicDataAPIRunnerConfig;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.seijuro.common.scrap.publicdata.runner.config.PublicDataAPIRunnerConfig.Property;

public class PublicDataAPIRunner {
    /**
     * ConfigUtils
     */
    static class ConfigUtils {
        static int getThreadPoolSize(PublicDataAPIRunnerConfig config) {
            int size = config.contains(Property.THREADPOOL_SIZE) ? config.get(Property.THREADPOOL_SIZE, Integer.class) : PublicDataAPIRunnerConfig.getDefaultThreadPoolSize();

            return size + 1;
        }

        static long getAwaitTermMillis(PublicDataAPIRunnerConfig config) {
            return config.contains(Property.AWAITTERM_MILLIS) ? config.get(Property.AWAITTERM_MILLIS, Long.class) : PublicDataAPIRunnerConfig.getDefaultAwaitTermMillis();
        }
    }

    @Getter(AccessLevel.PROTECTED)
    private final ExecutorService executor;
    private final long awaitTermMillis;

    private final List<IPublicDataAPIRunnable> runnables = new ArrayList<>();
    private final Thread hookShutdownThread;

    /**
     * C'tor
     *
     * @param config
     */
    public PublicDataAPIRunner(PublicDataAPIRunnerConfig config) {
        this(Executors.newFixedThreadPool(ConfigUtils.getThreadPoolSize(config)), ConfigUtils.getAwaitTermMillis(config));
    }

    public PublicDataAPIRunner(PublicDataAPIRunnerConfig config, ExecutorService executor) {
        this(executor, ConfigUtils.getAwaitTermMillis(config));
    }

    /**
     * C'tor
     *
     * @param $executor
     * @param $awaitTermMillis
     */
    public PublicDataAPIRunner(ExecutorService $executor, long $awaitTermMillis) {
        this.executor = $executor;
        this.awaitTermMillis = $awaitTermMillis;
        this.hookShutdownThread = new Thread(() -> {
            for (IPublicDataAPIRunnable runnable : runnables) {
                runnable.shutdown();
            }

            try {
                executor.awaitTermination(awaitTermMillis, TimeUnit.MILLISECONDS);
            }
            catch (InterruptedException excp) {
                excp.printStackTrace();
            }
        });

        Runtime.getRuntime().addShutdownHook(this.hookShutdownThread);
    }
}
