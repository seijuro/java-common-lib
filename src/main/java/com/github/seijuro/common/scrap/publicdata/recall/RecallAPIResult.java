package com.github.seijuro.common.scrap.publicdata.recall;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RecallAPIResult {
    @SerializedName(RecallProperty.ENABLE)
    private final Boolean enabled;
    @SerializedName(RecallProperty.NUMBER)
    private final Integer number;
    @SerializedName(RecallProperty.SIZE)
    private final Integer size;
    @SerializedName(RecallProperty.TOTAL_PAGES)
    private final Integer totalPages;
    @SerializedName(RecallProperty.NUMBER_OF_ELEMENTS)
    private final Integer numOfElements;
    @SerializedName(RecallProperty.TOTAL_ELEMENTS)
    private final Integer totalElements;
    @SerializedName(RecallProperty.HAS_PREVIOUS_PAGE)
    private final Boolean hasPreviousPage;
    @SerializedName(RecallProperty.HAS_NEXT_PAGE)
    private final Boolean hasNextPage;
    @SerializedName(RecallProperty.IS_FIRST_PAGE)
    private final Boolean isFirstPage;
    @SerializedName(RecallProperty.IS_LAST_PAGE)
    private final Boolean isLastPage;
    @SerializedName(RecallProperty.HAS_CONTENTS)
    private final Boolean hasContent;
    @SerializedName(RecallProperty.BEGIN_PAGE)
    private final Integer beginPage;
    @SerializedName(RecallProperty.END_PAGE)
    private final Integer endPage;
    @SerializedName(RecallProperty.PREVIOUS_PAGE)
    private final Integer previousPage;
    @SerializedName(RecallProperty.NEXT_PAGE)
    private final Integer nextPage;
    @SerializedName(RecallProperty.CONTENT)
    private final ArrayList<Recall> content;
}
