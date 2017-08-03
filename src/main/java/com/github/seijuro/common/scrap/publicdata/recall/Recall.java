package com.github.seijuro.common.scrap.publicdata.recall;

import com.github.seijuro.common.scrap.publicdata.PublicData;
import com.google.gson.annotations.SerializedName;
import org.junit.Test;

import java.util.function.Consumer;

public class Recall extends PublicData {
    /**
     * Instance Properties
     */
    @SerializedName(RecallProperty.Content.FieldName.IDX)
    private final int idx;
    @SerializedName(RecallProperty.Content.FieldName.COUNTRY_OF_MANUFACTURE)
    private final String countryOfManufacture;
    @SerializedName(RecallProperty.Content.FieldName.TRADEMARK)
    private final String trademark;
    @SerializedName(RecallProperty.Content.FieldName.PRODUCT_NAME)
    private final String productName;
    @SerializedName(RecallProperty.Content.FieldName.MODEL)
    private final String model;
    @SerializedName(RecallProperty.Content.FieldName.SERIAL_NUMBER)
    private final String serialNumber;
    @SerializedName(RecallProperty.Content.FieldName.TYPE)
    private final String type;
    @SerializedName(RecallProperty.Content.FieldName.COMPANY)
    private final String company;
    @SerializedName(RecallProperty.Content.FieldName.DATE_OF_ISSUE)
    private final String dateOfIssue;
    @SerializedName(RecallProperty.Content.FieldName.DIMENSION_TYPE)
    private final int dimensionType;
    @SerializedName(RecallProperty.Content.FieldName.Extra)
    private final RecallExtra extra;

    /**
     * C'tor
     *
     * @param builder
     */
    protected Recall(Builder builder) {
        super(builder);

        this.idx = builder.idx;
        this.countryOfManufacture = builder.countryOfManufacture;
        this.productName = builder.productName;
        this.trademark = builder.trademark;
        this.model = builder.model;
        this.serialNumber = builder.serialNumber;
        this.type = builder.type;
        this.company = builder.company;
        this.dateOfIssue = builder.dateOfIssue;
        this.dimensionType = builder.dimensionType;
        this.extra = builder.extra;
    }

    @Test
    @Override
    public void prettyPrint(Consumer<String> consumer) {
        StringBuffer sb = new StringBuffer();

        sb.append("[recall] :=\b")
                .append("idx : [").append(this.idx).append("]\n")
                .append("country of manufacture : [").append(this.countryOfManufacture).append("]\n")
                .append("product name : [").append(this.productName).append("]\n")
                .append("trademark : [").append(this.trademark).append("]\n")
                .append("model : [").append(this.model).append("]\n")
                .append("serial# : [").append(this.serialNumber).append("]\n")
                .append("type : [").append(this.type).append("]\n")
                .append("company : [").append(this.company).append("]\n")
                .append("date of issue : [").append(this.dateOfIssue).append("]\n")
                .append("dimension of nation type : [").append(this.dimensionType).append("]\n")
                .append("extra : [").append(this.extra).append("]\n");

        consumer.accept(sb.toString());
    }

    /**
     * Builder pattern class
     */
    public static class Builder extends PublicData.Builder {
        private int idx = Integer.MIN_VALUE;
        private String countryOfManufacture = null;
        private String productName = null;
        private String trademark = null;
        private String model = null;
        private String serialNumber = null;
        private String type = null;
        private String company = null;
        private String dateOfIssue = null;
        private int dimensionType = Integer.MIN_VALUE;
        private final RecallExtra extra = null;

        @Override
        public Recall build() {
            return new Recall(this);
        }
    }
}
