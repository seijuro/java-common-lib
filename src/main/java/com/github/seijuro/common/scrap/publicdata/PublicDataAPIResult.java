package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.IPrettyPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PublicDataAPIResult implements IPrettyPrint {
    private final String resultCode;
    private final String resultMsg;
    private int pageNo;
    private int numOfRows;
    private int totalCount;

    protected List<PublicData> resultList = new ArrayList<>();

    /**
     * C'tor
     *
     * @param $resultCode
     * @param $resultMesg
     * @param $pageNo
     * @param $numOfRows
     * @param $totalCount
     */
    public PublicDataAPIResult(String $resultCode, String $resultMesg, int $pageNo, int $numOfRows, int $totalCount) {
        this.resultCode = $resultCode;
        this.resultMsg = $resultMesg;
        this.pageNo = $pageNo;
        this.numOfRows = $numOfRows;
        this.totalCount = $totalCount;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultMessage() {
        return this.resultMsg;
    }

    public int getPageNo() {
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
        StringBuffer sb = new StringBuffer("result :=\n");

        sb.append("\t[common]").append("\n")
                .append("\t").append(PublicDataProperty.Result.RESULT_CODE).append(" : [").append(this.resultCode).append("]\n")
                .append("\t").append(PublicDataProperty.Result.RESULT_MESSAGE).append(" : [").append(this.resultMsg).append("]\n")
                .append("\t").append(PublicDataProperty.Result.PAGE_NO).append(" : [").append(this.pageNo).append("]\n")
                .append("\t").append(PublicDataProperty.Result.NUM_OF_ROWS).append(" : [").append(this.numOfRows).append("]\n")
                .append("\t").append(PublicDataProperty.Result.TOTAL_COUNT).append(" : [").append(this.totalCount).append("]\n");

        consumer.accept(sb.toString());
    }

    /**
     * set all elements in param
     *
     * @param list
     */
    public void setData(List<? extends PublicData> list) {
        this.resultList.clear();

        addData(list);
    }

    /**
     * add data all elements in param
     *
     * @param list
     */
    public void addData(List<? extends PublicData> list) {
        if (this.resultList != null) {
            list.forEach(this.resultList::add);
        }
    }

    /**
     * add datum
     *
     * @param element
     * @param <T>
     */
    public <T extends PublicData> void addDatum(T element) {
        if (element != null) {
            this.resultList.add(element);
        }
    }

    /**
     * get list which contains all elements.
     *
     * @param Clazz
     * @param <T>
     * @return
     */
    public <T extends PublicData> List<T> getData(Class<T> Clazz) {
        List<T> ret = new ArrayList<>();

        this.resultList.forEach(e -> {
            ret.add(Clazz.cast(e));
        });

        return ret;
    }
}
