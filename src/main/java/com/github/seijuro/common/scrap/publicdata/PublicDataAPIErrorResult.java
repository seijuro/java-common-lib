package com.github.seijuro.common.scrap.publicdata;

import java.util.function.Consumer;

public class PublicDataAPIErrorResult extends PublicDataAPIResult {
    private final String reasonCode;
    private final String errorMessage;
    private final String authenticationMsg;

    public PublicDataAPIErrorResult(String code, String msg, String authMsg) {
        super(null, null, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

        this.reasonCode = code;
        this.errorMessage = msg;
        this.authenticationMsg = authMsg;
    }

    @Override
    public void prettyPrint(Consumer<String> consumer) {
        StringBuffer sb = new StringBuffer("error := {");

        sb.append(PublicDataProperty.Error.REASON_CODE).append(" : [").append(this.reasonCode).append("], ");
        sb.append(PublicDataProperty.Error.ERROR_MESSAGE).append(" : [").append(this.errorMessage).append("]");
        sb.append(PublicDataProperty.Error.AUTHENTICATION_MESSAGE).append(" : [").append(this.authenticationMsg).append("]}");

        consumer.accept(sb.toString());
    }
}
