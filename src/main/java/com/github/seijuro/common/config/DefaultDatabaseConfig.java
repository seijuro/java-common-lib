package com.github.seijuro.common.config;

import lombok.NonNull;

public enum DefaultDatabaseConfig implements Config {
    db_host,
    db_user,
    db_passwd,
    db_database,
    db_others;

    @NonNull
    @Override
    public String getKey() {
        return name();
    }
}
