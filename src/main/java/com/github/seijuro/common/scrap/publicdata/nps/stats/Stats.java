package com.github.seijuro.common.scrap.publicdata.nps.stats;

import com.github.seijuro.common.IPrettyPrint;
import com.github.seijuro.common.scrap.publicdata.nps.NPSData;

import java.util.function.Consumer;

public class Stats extends NPSData implements IPrettyPrint {
    /**
     * Instance Properties
     */
    private final String monthlyEmployment;
    private final String monthlyRetirement;

    protected Stats(Builder builer) {
        super(builer);

        this.monthlyEmployment = builer.monthlyEmployment;
        this.monthlyRetirement = builer.monthlyRetirement;
    }

    public String getMonthlyEmployment() {
        return this.monthlyEmployment;
    }

    public String getMonthlyRetirement() {
        return this.monthlyRetirement;
    }

    @Override
    public void prettyPrint(Consumer<String> consumer) {
        StringBuffer sb = new StringBuffer();

        consumer.accept(sb.toString());
    }

    /**
     * Builder Pattern class
     */
    public static class Builder extends NPSData.Builder {
        /**
         * Instance Properties
         */
        private String monthlyEmployment;
        private String monthlyRetirement;

        /**
         * Builder Pattern class
         */
        public Builder() {
            super();
        }

        public Builder setMonthlyEmpolyment(String value) {
            this.monthlyEmployment = value;
            return this;
        }

        public Builder setMonthlyRetirement(String value) {
            this.monthlyRetirement = value;
            return this;
        }

        public Stats build() {
            return new Stats(this);
        }
    }
}
