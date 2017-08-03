package com.github.seijuro.common.scrap.publicdata.nps.stats;

import com.github.seijuro.common.IPrettyPrint;
import com.github.seijuro.common.scrap.publicdata.nps.NPSData;
import lombok.*;

import java.util.function.Consumer;

@ToString
@EqualsAndHashCode(callSuper = true)
public class Stats extends NPSData implements IPrettyPrint {
    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PUBLIC)
    private final String monthlyEmployment;
    @Getter(AccessLevel.PUBLIC)
    private final String monthlyRetirement;

    protected Stats(Builder builer) {
        super(builer);

        this.monthlyEmployment = builer.monthlyEmployment;
        this.monthlyRetirement = builer.monthlyRetirement;
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
        @Setter(AccessLevel.PUBLIC)
        private String monthlyEmployment;
        @Setter(AccessLevel.PUBLIC)
        private String monthlyRetirement;

        /**
         * Builder Pattern class
         */
        public Builder() {
            super();
        }

        public Stats build() {
            return new Stats(this);
        }
    }
}
