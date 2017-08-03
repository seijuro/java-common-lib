package com.github.seijuro.common.scrap.publicdata.nps.detail;

import com.github.seijuro.common.scrap.publicdata.nps.NPSProperty;
import com.github.seijuro.common.scrap.publicdata.nps.normal.BusinessPlaceInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

public class BusinessPlaceDetailInfo extends BusinessPlaceInfo {
    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PUBLIC)
    private final String businessTypeName;
    @Getter(AccessLevel.PUBLIC)
    private final String businessTypeCode;
    @Getter(AccessLevel.PUBLIC)
    private final String registrationDate;
    @Getter(AccessLevel.PUBLIC)
    private final String withdrawalDate;
    @Getter(AccessLevel.PUBLIC)
    private final String subscriberNumber;
    @Getter(AccessLevel.PUBLIC)
    private final String notifiedAmountOfThisMonth;

    /**
     * C'tor
     *
     * @param builder
     */
    protected BusinessPlaceDetailInfo(Builder builder) {
        super(builder);

        this.businessTypeName = builder.businessTypeName;
        this.businessTypeCode = builder.businessTypeCode;
        this.registrationDate = builder.registrationDate;
        this.withdrawalDate = builder.withdrawalDate;
        this.subscriberNumber = builder.subscriberNumber;
        this.notifiedAmountOfThisMonth = builder.notifiedAmountOfThisMonth;
    }

    @Override
    public void prettyPrint(Consumer<String> consumer) {
        super.prettyPrint(consumer);

        StringBuffer sb = new StringBuffer();
        sb.append("\t[detail]")
                .append("\t").append(NPSProperty.Item.Detail.BUSINESSTYPE_NAME).append(" : [").append(this.businessTypeName).append("]\n")
                .append("\t").append(NPSProperty.Item.Detail.BUSINESSTYPE_CODE).append(" : [").append(this.businessTypeCode).append("]\n")
                .append("\t").append(NPSProperty.Item.Detail.REGISTRATION_DATE).append(" : [").append(this.registrationDate).append("]\n")
                .append("\t").append(NPSProperty.Item.Detail.WITHDRAWAL_DATE).append(" : [").append(this.withdrawalDate).append("]\n")
                .append("\t").append(NPSProperty.Item.Detail.SUBSCRIBER_NUMBER).append(" : [").append(this.subscriberNumber).append("]\n")
                .append("\t").append(NPSProperty.Item.Detail.NOTIFIED_AMOUNT_OF_THIS_MONTH).append(" : [").append(this.notifiedAmountOfThisMonth).append("]");

        consumer.accept(sb.toString());
    }

    /**
     * Builder Pattern class
     */
    public static class Builder extends BusinessPlaceInfo.Builder {
        /**
         * Instance Properties
         */
        @Setter(AccessLevel.PUBLIC)
        private String businessTypeName = null;
        @Setter(AccessLevel.PUBLIC)
        private String businessTypeCode = null;
        @Setter(AccessLevel.PUBLIC)
        private String registrationDate = null;
        @Setter(AccessLevel.PUBLIC)
        private String withdrawalDate = null;
        @Setter(AccessLevel.PUBLIC)
        private String subscriberNumber = null;
        @Setter(AccessLevel.PUBLIC)
        private String notifiedAmountOfThisMonth = null;

        /**
         * Builder Pattern method
         *
         * @return
         */
        @Override
        public BusinessPlaceDetailInfo build() {
            return new BusinessPlaceDetailInfo(this);
        }
    }
}
