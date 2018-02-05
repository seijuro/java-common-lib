package com.github.seijuro.common.param;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@ToString
public class OptionalParameter implements Comparable<OptionalParameter> {
    @Getter
    private final String parameter;
    @Getter
    private final String value;

    public OptionalParameter(String param) {
        this(param, StringUtils.EMPTY);
    }

    public OptionalParameter(String param, String value) {
        this.parameter = param;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return parameter.hashCode();
    }

    @Override
    public int compareTo(OptionalParameter o) {
        return hashCode() - o.hashCode();
    }
}
