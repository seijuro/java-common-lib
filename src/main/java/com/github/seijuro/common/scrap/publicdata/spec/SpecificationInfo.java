package com.github.seijuro.common.scrap.publicdata.spec;

import com.github.seijuro.common.scrap.publicdata.PublicData;

import java.util.function.Consumer;

public class SpecificationInfo extends PublicData {
    /**
     * Instance Properties
     */
    private final String businessDivisionName;
    private final String refNo;
    private final String productName;
    private final String orderingInstName;
    private final String demandInstName;
    private final String assignBudgetAmount;
    private final String receiptDate;
    private final String regOptionDueDate;
    private final String officalTel;
    private final String officalName;
    private final String isSWBusiness;
    private final String deliveryDueDate;
    private final String deliveryDayNum;
    private final String specificationRegNo;
    private final String specificationDocFileURL1;
    private final String specificationDocFileURL2;
    private final String specificationDocFileURL3;
    private final String specificationDocFileURL4;
    private final String specificationDocFileURL5;
    private final String productDetails;
    private final String regDate;
    private final String changedDate;
    private final String bidNoticeNoList;

    /**
     * C'tor for Builder
     *
     * @param builder
     */
    protected SpecificationInfo(Builder builder) {
        this.businessDivisionName = builder.businessDivisionName;
        this.refNo = builder.refNo;
        this.productName = builder.productName;
        this.orderingInstName = builder.orderingInstName;
        this.demandInstName = builder.demandInstName;
        this.assignBudgetAmount = builder.assignBudgetAmount;
        this.receiptDate = builder.receiptDate;
        this.regOptionDueDate = builder.regOptionDueDate;
        this.officalTel = builder.officalTel;
        this.officalName = builder.officalName;
        this.isSWBusiness = builder.isSWBusiness;
        this.deliveryDueDate = builder.deliveryDueDate;
        this.deliveryDayNum = builder.deliveryDayNum;
        this.specificationRegNo = builder.specificationRegNo;
        this.specificationDocFileURL1 = builder.specificationDocFileURL1;
        this.specificationDocFileURL2 = builder.specificationDocFileURL2;
        this.specificationDocFileURL3 = builder.specificationDocFileURL3;
        this.specificationDocFileURL4 = builder.specificationDocFileURL4;
        this.specificationDocFileURL5 = builder.specificationDocFileURL5;
        this.productDetails = builder.productDetails;
        this.regDate = builder.regDate;
        this.changedDate = builder.changedDate;
        this.bidNoticeNoList = builder.bidNoticeNoList;
    }

    @Override
    public void prettyPrint(Consumer<String> consumer) {
        StringBuffer sb = new StringBuffer();

        consumer.accept(sb.toString());
    }

    /**
     * Builder Pattern class
     */
    public static class Builder extends PublicData.Builder {
        /**
         * Instance Properties
         */
        private String businessDivisionName;
        private String refNo;
        private String productName;
        private String orderingInstName;
        private String demandInstName;
        private String assignBudgetAmount;
        private String receiptDate;
        private String regOptionDueDate;
        private String officalTel;
        private String officalName;
        private String isSWBusiness;
        private String deliveryDueDate;
        private String deliveryDayNum;
        private String specificationRegNo;
        private String specificationDocFileURL1;
        private String specificationDocFileURL2;
        private String specificationDocFileURL3;
        private String specificationDocFileURL4;
        private String specificationDocFileURL5;
        private String productDetails;
        private String regDate;
        private String changedDate;
        private String bidNoticeNoList;

        /**
         * build : Builder patthern method
         *
         * @return
         */
        public SpecificationInfo build() {
            return new SpecificationInfo(this);
        }

        public Builder setBusinessDivisionName(String name) {
            this.businessDivisionName = name;
            return this;
        }

        public Builder setReferenceNo(String no) {
            this.refNo = no;
            return this;
        }

        public Builder setProductName(String name) {
            this.productName = name;
            return this;
        }

        public Builder setOrderingInstName(String name) {
            this.orderingInstName = name;
            return this;
        }

        public Builder setDemandInstName(String name) {
            this.demandInstName = name;
            return this;
        }

        public Builder setAssignBudgetAmount(String amount) {
            this.assignBudgetAmount = amount;
            return this;
        }

        public Builder setReceiptDate(String date) {
            this.receiptDate = date;
            return this;
        }

        public Builder setRegisterOptionDueDate(String date) {
            this.regOptionDueDate = date;
            return this;
        }

        public Builder setOfficialTel(String tel) {
            this.officalTel = tel;
            return this;
        }

        public Builder setOfficalName(String name) {
            this.officalName = name;
            return this;
        }

        public Builder setIsSWBusiness(String flag) {
            this.isSWBusiness = flag;
            return this;
        }

        public Builder setDeliveryDueDate(String date) {
            this.deliveryDueDate = date;
            return this;
        }

        public Builder setDeliveryDayNum(String num) {
            this.deliveryDayNum = num;
            return this;
        }

        public Builder setSpecificationRegNo(String no) {
            this.specificationRegNo = no;
            return this;
        }

        public Builder setSpecificationDocFileURL1(String url) {
            this.specificationDocFileURL1 = url;
            return this;
        }

        public Builder setSpecificationDocFileURL2(String url) {
            this.specificationDocFileURL2 = url;
            return this;
        }

        public Builder setSpecificationDocFileURL3(String url) {
            this.specificationDocFileURL3 = url;
            return this;
        }

        public Builder setSpecificationDocFileURL4(String url) {
            this.specificationDocFileURL4 = url;
            return this;
        }

        public Builder setSpecificationDocFileURL5(String url) {
            this.specificationDocFileURL5 = url;
            return this;
        }

        public Builder setProductDetails(String value) {
            this.productDetails = value;
            return this;
        }

        public Builder setRegDate(String date) {
            this.regDate = date;
            return this;
        }

        public Builder setChangedDate(String date) {
            this.changedDate = date;
            return this;
        }

        public Builder setBidNoticeNoList(String list) {
            this.bidNoticeNoList = list;
            return this;
        }
    }
}
