package com.github.seijuro.common;

import java.util.function.Consumer;

public interface IPrettyPrint {
    public void prettyPrint(Consumer<String> consumer);
}
