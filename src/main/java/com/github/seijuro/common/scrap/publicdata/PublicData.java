package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.IPrettyPrint;

import java.util.function.Consumer;

public abstract class PublicData extends Object implements IPrettyPrint {
    /**
     * Default C'tor
     */
    public PublicData() {
    }

    /**
     * C'tor for builder
     *
     * @param builder
     */
    public PublicData(Builder builder) {
    }

    @Override
    public void prettyPrint(Consumer<String> consumer) {
        //  default impl.
    }

    /**
     * Builder Pattern class
     */
    public static abstract class Builder {
        public abstract PublicData build();
    }
}
