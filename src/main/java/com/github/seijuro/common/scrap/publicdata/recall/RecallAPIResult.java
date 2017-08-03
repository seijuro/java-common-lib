package com.github.seijuro.common.scrap.publicdata.recall;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResult;
import com.google.gson.annotations.SerializedName;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RecallAPIResult extends PublicDataAPIResult {
    /**
     * Instance Properties
     */
    private final Boolean enabled;
    private final Integer totalPages;
    private final Boolean hasPreviousPage;
    private final Boolean hasNextPage;
    private final Boolean isFirstPage;
    private final Boolean isLastPage;
    private final Boolean hasContent;
    private final Integer beginPage;
    private final Integer endPage;
    private final Integer previousPage;
    private final Integer nextPage;

    /**
     * C'tor
     *
     * @param builder
     */
    protected RecallAPIResult(Builder builder) {
        super(null, null, builder.number, builder.numOfElements, builder.totalElements);

        this.enabled = builder.enabled;
        this.totalPages = builder.totalPages;
        this.hasPreviousPage = builder.hasPreviousPage;
        this.hasNextPage = builder.hasNextPage;
        this.isFirstPage = builder.isFirstPage;
        this.isLastPage = builder.isLastPage;
        this.hasContent = builder.hasContent;
        this.beginPage = builder.beginPage;
        this.endPage = builder.endPage;
        this.previousPage = builder.previousPage;
        this.nextPage = builder.nextPage;

        addData(builder.content);
    }

    @Override
    public void prettyPrint(Consumer<String> consumer) {
        super.prettyPrint(consumer);

        StringBuffer sb = new StringBuffer("[recall]\n");
        sb.append("\t").append(RecallProperty.ENABLE).append(" : [").append(this.enabled).append("]\n")
                .append("\t").append(RecallProperty.TOTAL_PAGES).append(" : [").append(this.totalPages).append("]\n")
                .append("\t").append(RecallProperty.HAS_PREVIOUS_PAGE).append(" : [").append(this.hasPreviousPage).append("]\n")
                .append("\t").append(RecallProperty.HAS_NEXT_PAGE).append(" : [").append(this.hasNextPage).append("]\n")
                .append("\t").append(RecallProperty.IS_FIRST_PAGE).append(" : [").append(this.isFirstPage).append("]\n")
                .append("\t").append(RecallProperty.IS_LAST_PAGE).append(" : [").append(this.isLastPage).append("]\n")
                .append("\t").append(RecallProperty.HAS_CONTENTS).append(" : [").append(this.hasContent).append("]\n")
                .append("\t").append(RecallProperty.BEGIN_PAGE).append(" : [").append(this.beginPage).append("]\n")
                .append("\t").append(RecallProperty.END_PAGE).append(" : [").append(this.endPage).append("]\n")
                .append("\t").append(RecallProperty.PREVIOUS_PAGE).append(" : [").append(this.previousPage).append("]\n")
                .append("\t").append(RecallProperty.NEXT_PAGE).append(" : [").append(this.nextPage).append("]\n");

        consumer.accept(sb.toString());

        List<Recall> data = getData(Recall.class);

        for (Recall recall : data) {
            recall.prettyPrint(consumer);
        }
    }

    /**
     * Builder Pattern method.
     */
    public static class Builder {
        @SerializedName(RecallProperty.ENABLE)
        private Boolean enabled;
        @SerializedName(RecallProperty.NUMBER)
        private Integer number;
        @SerializedName(RecallProperty.SIZE)
        private Integer size;
        @SerializedName(RecallProperty.TOTAL_PAGES)
        private Integer totalPages;
        @SerializedName(RecallProperty.NUMBER_OF_ELEMENTS)
        private Integer numOfElements;
        @SerializedName(RecallProperty.TOTAL_ELEMENTS)
        private Integer totalElements;
        @SerializedName(RecallProperty.HAS_PREVIOUS_PAGE)
        private Boolean hasPreviousPage;
        @SerializedName(RecallProperty.HAS_NEXT_PAGE)
        private Boolean hasNextPage;
        @SerializedName(RecallProperty.IS_FIRST_PAGE)
        private Boolean isFirstPage;
        @SerializedName(RecallProperty.IS_LAST_PAGE)
        private Boolean isLastPage;
        @SerializedName(RecallProperty.HAS_CONTENTS)
        private Boolean hasContent;
        @SerializedName(RecallProperty.BEGIN_PAGE)
        private Integer beginPage;
        @SerializedName(RecallProperty.END_PAGE)
        private Integer endPage;
        @SerializedName(RecallProperty.PREVIOUS_PAGE)
        private Integer previousPage;
        @SerializedName(RecallProperty.NEXT_PAGE)
        private Integer nextPage;
        @SerializedName(RecallProperty.CONTENT)
        private ArrayList<Recall> content;

        /**
         * Builder pattern method
         * @return
         */
        @Test
        public RecallAPIResult build() {
            return new RecallAPIResult(this);
        }
    }
}
