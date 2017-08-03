package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.IPrettyPrint;

import java.util.function.Consumer;

public abstract class PublicData implements IPrettyPrint {
    @Override
    public void prettyPrint(Consumer<String> consumer) {
        //  default impl.
    }

    public static abstract class Builder {
    }
}
