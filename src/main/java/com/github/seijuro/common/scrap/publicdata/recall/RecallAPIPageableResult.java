package com.github.seijuro.common.scrap.publicdata.recall;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResult;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Getter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RecallAPIResult extends PublicDataAPIResult {
    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PUBLIC)
    private final Boolean enabled;
    @Getter(AccessLevel.PUBLIC)
    private final Integer totalPages;
    @Getter(AccessLevel.PUBLIC)
    private final Boolean hasPreviousPage;
    @Getter(AccessLevel.PUBLIC)
    private final Boolean hasNextPage;
    @Getter(AccessLevel.PUBLIC)
    private final Boolean isFirstPage;
    @Getter(AccessLevel.PUBLIC)
    private final Boolean isLastPage;
    @Getter(AccessLevel.PUBLIC)
    private final Boolean hasContent;
    @Getter(AccessLevel.PUBLIC)
    private final Integer beginPage;
    @Getter(AccessLevel.PUBLIC)
    private final Integer endPage;
    @Getter(AccessLevel.PUBLIC)
    private final Integer previousPage;
    @Getter(AccessLevel.PUBLIC)
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
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.ENABLE)
        private Boolean enabled;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.NUMBER)
        private Integer number;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.SIZE)
        private Integer size;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.TOTAL_PAGES)
        private Integer totalPages;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.NUMBER_OF_ELEMENTS)
        private Integer numOfElements;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.TOTAL_ELEMENTS)
        private Integer totalElements;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.HAS_PREVIOUS_PAGE)
        private Boolean hasPreviousPage;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.HAS_NEXT_PAGE)
        private Boolean hasNextPage;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.IS_FIRST_PAGE)
        private Boolean isFirstPage;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.IS_LAST_PAGE)
        private Boolean isLastPage;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.HAS_CONTENTS)
        private Boolean hasContent;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.BEGIN_PAGE)
        private Integer beginPage;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.END_PAGE)
        private Integer endPage;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.PREVIOUS_PAGE)
        private Integer previousPage;
        @Getter(AccessLevel.PUBLIC)
        @SerializedName(RecallProperty.NEXT_PAGE)
        private Integer nextPage;
        @Getter(AccessLevel.PUBLIC)
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
