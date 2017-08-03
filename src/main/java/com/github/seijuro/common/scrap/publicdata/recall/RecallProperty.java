package com.github.seijuro.common.scrap.publicdata.recall;

public class RecallProperty {
    enum Field {
        IDX("idx"),
        CONTRY_OF_MANUFACTURE("makingNation"),
        PRODUCT_NAME("produtName"),
        TRADEMARK("trademark"),
        MODEL("model"),
        SERIAL_NUMBER("serialNumber"),
        TYPE("recallType"),
        COMPANY("companyName"),
        DATE_OF_ISSUE("signDate"),
        DIMENSION_TYPE("recallNationType");

        private final String fieldName;

        Field(String name) {
            this.fieldName = name;
        }

        @Override
        public String toString() {
            return this.fieldName;
        }
    }
}
