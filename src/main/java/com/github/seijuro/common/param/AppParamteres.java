package com.github.seijuro.common.param;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppParamteres {
    public interface Reserved {
        public String toText();
    }

    private final List<OptionalParameter> params;

    /**
     * Instance Properties
     */
    private List<OptionalParameter> parameters = new ArrayList<>();

    public AppParamteres(String[] args) {
        params = OptionalParametersParser.parseParameters(args);
    }

    public boolean exists(String param) {
        if (StringUtils.isNotEmpty(param)) {
            for (OptionalParameter p : params) {
                if (param.equals(p.getParameter())) {
                    return true;
                }
            }
        }

        return false;
    }

    public OptionalParameter getParam(String param) {
        if (StringUtils.isNotEmpty(param)) {
            for (OptionalParameter p : params) {
                if (param.equals(p.getParameter())) {
                    return p;
                }
            }
        }

        return null;
    }

    public OptionalParameter getParam(AppParamteres.Reserved param) {
        Objects.requireNonNull(param);

        return getParam(param.toText());
    }

    public int size() {
        return params.size();
    }
}
