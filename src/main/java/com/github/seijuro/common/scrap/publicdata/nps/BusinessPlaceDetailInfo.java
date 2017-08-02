package com.github.seijuro.common.scrap.publicdata.nps;

public class BusinessPlaceDetailInfo extends BusinessPlaceInfo {
    /**
     * Instance Properties
     */
    private final String businessTypeName;
    private final String businessTypeCode;
    private final String registrationDate;
    private final String withdrawalDate;
    private final String subscriberNumber;
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

    public String getBusinessTypeName() {
        return this.businessTypeName;
    }

    public String getBusinessTypeCode() {
        return this.businessTypeCode;
    }

    public String getRegistrationDate() {
        return this.registrationDate;
    }

    public String getWithdrawalDate() {
        return this.withdrawalDate;
    }

    public String getSubscriberNumber() {
        return this.subscriberNumber;
    }

    public String getNotifiedAmountOfThisMonth() {
        return this.notifiedAmountOfThisMonth;
    }

    /**
     * Builder Pattern class
     */
    public static class Builder extends BusinessPlaceInfo.Builder {
        /**
         * Instance Properties
         */
        private String businessTypeName = null;
        private String businessTypeCode = null;
        private String registrationDate = null;
        private String withdrawalDate = null;
        private String subscriberNumber = null;
        private String notifiedAmountOfThisMonth = null;

        public Builder setBusinessTypeName(String name) {
            this.businessTypeName = name;
            return this;
        }

        public Builder setBusinessTypeCode(String code) {
            this.businessTypeCode = code;
            return this;
        }

        public Builder setRegistrationDate(String date) {
            this.registrationDate = date;
            return this;
        }

        public Builder setWithdrawalDate(String date) {
            this.withdrawalDate = date;
            return this;
        }

        public Builder setSubscriberNumber(String number) {
            this.subscriberNumber = number;
            return this;
        }

        public Builder setNotifiedAmountOfThisMonth(String amount) {
            this.notifiedAmountOfThisMonth = amount;
            return this;
        }
    }
}
