package com.github.seijuro.common.scrap.publicdata.nps.normal;

import com.github.seijuro.common.scrap.publicdata.nps.NPSData;
import com.github.seijuro.common.scrap.publicdata.nps.NPSProperty;

import java.util.function.Consumer;

public class BusinessPlaceInfo extends NPSData {
    /**
     * Instsance Properties
     */
    private final String id;
    private final String createdDatedYM;
    private final String name;
    private final String registrationNumber;
    private final String addrStreet;
    private final String statusCode;
    private final String divisionCode;
    private final String addrCodeDG;
    private final String addrCodeSGG;
    private final String addrCodeEMD;

    /**
     * C'tor for builder
     *
     * @param builder
     */
    protected BusinessPlaceInfo(Builder builder) {
        super(builder);

        this.id = builder.id;
        this.createdDatedYM = builder.createdDatedYM;
        this.name = builder.name;
        this.registrationNumber = builder.registrationNumber;
        this.addrStreet = builder.addrStreet;
        this.statusCode = builder.statusCode;
        this.divisionCode = builder.divisionCode;
        this.addrCodeDG = builder.addrCodeDG;
        this.addrCodeSGG = builder.addrCodeSGG;
        this.addrCodeEMD = builder.addrCodeEMD;
    }

    public String getID() {
        return this.id;
    }

    public String getCreatedDatedYM() {
        return this.createdDatedYM;
    }

    public String getName(String $name) {
        return this.name;
    }

    public String getRegistrationNumber(String number) {
        return this.registrationNumber;
    }

    public String getStreetAddress(String addr) {
        return this.addrStreet;
    }

    public String getStatusCode(String code) {
        return this.statusCode;
    }

    public String getDivisionCode(String code) {
        return this.divisionCode;
    }

    public String getAddressCodeDB(String code) {
        return this.addrCodeDG;
    }

    public String getAddressCodeSGG(String code) {
        return this.addrCodeSGG;
    }

    public String getAddressCodeEMD(String code) {
        return this.addrCodeEMD;
    }

    @Override
    public void prettyPrint(Consumer<String> consumer) {
        StringBuffer sb = new StringBuffer();

        sb.append("business place information := \n")
                .append("\t").append(NPSProperty.Item.Normal.ID).append(" : [").append(this.id).append("]\n")
                .append("\t").append(NPSProperty.Item.Normal.CREATED_YM).append(" : [").append(this.createdDatedYM).append("]\n")
                .append("\t").append(NPSProperty.Item.Normal.BUSINESSPLACE_NAME).append(" : [").append(this.name).append("]\n")
                .append("\t").append(NPSProperty.Item.Normal.REGISTRATION_NUMBER).append(" : [").append(this.registrationNumber).append("]\n")
                .append("\t").append(NPSProperty.Item.Normal.ADDRESS_STREET).append(" : [").append(this.addrStreet).append("]\n")
                .append("\t").append(NPSProperty.Item.Normal.STATUS_CODE).append(" : [").append(this.statusCode).append("]\n")
                .append("\t").append(NPSProperty.Item.Normal.DIVISION_CODE).append(" : [").append(this.divisionCode).append("]\n")
                .append("\t").append(NPSProperty.Item.Normal.ADDRESS_DG).append(" : [").append(this.addrCodeDG).append("]\n")
                .append("\t").append(NPSProperty.Item.Normal.ADDRESS_SGG).append(" : [").append(this.addrCodeSGG).append("]\n")
                .append("\t").append(NPSProperty.Item.Normal.ADDRESS_EMD).append(" : [").append(this.addrCodeEMD).append("]");

        consumer.accept(sb.toString());
    }

    /**
     * Builder Pattern class
     */
    public static class Builder extends NPSData.Builder {
        private String id = null;
        private String createdDatedYM = null;
        private String name = null;
        private String registrationNumber = null;
        private String addrStreet = null;
        private String statusCode = null;
        private String divisionCode = null;
        private String addrCodeDG = null;
        private String addrCodeSGG = null;
        private String addrCodeEMD = null;

        public Builder setID(String $id) {
            this.id = $id;
            return this;
        }

        public Builder setCreatedDateYM(String date) {
            this.createdDatedYM = date;
            return this;
        }

        public Builder setName(String $name) {
            this.name = $name;
            return this;
        }

        public Builder setRegistrationNumber(String number) {
            this.registrationNumber = number;
            return this;
        }

        public Builder setAddressStreet(String addr) {
            this.addrStreet = addr;
            return this;
        }

        public Builder setStatusCode(String code) {
            this.statusCode = code;
            return this;
        }

        public Builder setDivisionCode(String code) {
            this.divisionCode = code;
            return this;
        }

        public Builder setAddressCodeDG(String code) {
            this.addrCodeDG = code;
            return this;
        }

        public Builder setAddressCodeSGG(String code) {
            this.addrCodeSGG = code;
            return this;
        }

        public Builder setAddressCodeEMD(String code) {
            this.addrCodeEMD = code;
            return this;
        }

        /**
         * build : Builder Pattern method
         */
        @Override
        public BusinessPlaceInfo build() {
            return new BusinessPlaceInfo(this);
        }
    }
}
