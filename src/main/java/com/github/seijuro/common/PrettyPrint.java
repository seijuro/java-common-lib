package com.github.seijuro.common;

import java.util.function.Consumer;

public interface PrettyPrint {
    public void prettyPrint(Consumer<String> consumer);
}
