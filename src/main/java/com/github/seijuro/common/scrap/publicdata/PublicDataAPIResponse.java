package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.PrettyPrint;

import java.util.function.Consumer;

public class PublicDataAPIResponse implements PrettyPrint {
    private final String resultCode;
    private final String resultMsg;
    private int pageNo;
    private int numOfRows;
    private int totalCount;

    /**
     * C'tor
     *
     * @param $resultCode
     * @param $resultMesg
     * @param $pageNo
     * @param $numOfRows
     * @param $totalCount
     */
    public PublicDataAPIResponse(String $resultCode, String $resultMesg, int $pageNo, int $numOfRows, int $totalCount) {
        this.resultCode = $resultCode;
        this.resultMsg = $resultMesg;
        this.pageNo = $pageNo;
        this.numOfRows = $numOfRows;
        this.totalCount = $totalCount;
    }

    public int getPageNos() {
        return this.pageNo;
    }

    public int getNumberOfRows() {
        return this.numOfRows;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    @Override
    public void prettyPrint(Consumer<String> consumer) {
        StringBuffer sb = new StringBuffer("response := {type : [Normal], ");

        sb.append(PublicDataProperty.Result.RESULT_CODE).append(" = [").append(this.resultCode).append("], ");
        sb.append(PublicDataProperty.Result.RESULT_MESSAGE).append(" = [").append(this.resultMsg).append("], ");
        sb.append(PublicDataProperty.Result.PAGE_NO).append(" = [").append(this.pageNo).append("], ");
        sb.append(PublicDataProperty.Result.NUM_OF_ROWS).append(" = [").append(this.numOfRows).append("], ");
        sb.append(PublicDataProperty.Result.TOTAL_COUNT).append(" = [").append(this.totalCount).append("]}");

        consumer.accept(sb.toString());
    }
}
