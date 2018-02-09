package com.github.seijuro.common.config;

import lombok.NonNull;

public interface Config {
    @NonNull
    public abstract String getKey();
}
