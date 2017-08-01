package com.github.seijuro.common.webscrap.publicapi;

import com.github.seijuro.common.PrettyPrint;

import java.util.Properties;
import java.util.function.Consumer;

public class PublicDataAPIErrorResponse extends PublicDataAPIResponse implements PrettyPrint {
    protected final int reasonCode;
    protected final String errorMessage;

    protected Properties props = new Properties();

    public PublicDataAPIErrorResponse(int code, String msg) {
        super();

        this.reasonCode = code;
        this.errorMessage = msg;
    }

    public void setOther(String field, String value) {
        this.props.setProperty(field, value);
    }

    @Override
    public void prettyPrint(Consumer<String> consumer) {
        StringBuffer sb = new StringBuffer("ErrorResponse := {");

        sb.append(CommonProperty.Error.REASON_CODE).append(" : [").append(this.reasonCode).append("], ");
        sb.append(CommonProperty.Error.ERROR_MESSAGE).append(" : [").append(this.errorMessage).append("]");

        if (props.size() > 0) {
            for (String property : props.stringPropertyNames()) {
                sb.append(", ").append(property).append(" : [").append(props.getProperty(property)).append("]");
            }
        }

        sb.append("}");

        consumer.accept(sb.toString());
    }
}
