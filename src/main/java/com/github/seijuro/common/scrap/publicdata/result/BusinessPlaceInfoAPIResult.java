package com.github.seijuro.common.scrap.publicdata.result;

import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIResult;


public class BusinessPlaceInfoAPIResult extends PublicDataAPIResult {
    /**
     * C'tor
     *
     * @param $resultCode
     * @param $resultMesg
     * @param $pageNo
     * @param $numOfRows
     * @param $totalCount
     */
    public BusinessPlaceInfoAPIResult(String $resultCode, String $resultMesg, Integer $pageNo, Integer $numOfRows, Integer $totalCount) {
        super($resultCode, $resultMesg, $pageNo, $numOfRows, $totalCount);
    }

    /**
     * C'tor
     *
     * @param parent
     * @param <T>
     */
    public <T extends PublicDataAPIResult> BusinessPlaceInfoAPIResult(T parent) {
        super(parent.getResultCode(), parent.getResultMessage(), parent.getPageNo(), parent.getNumberOfRows(), parent.getTotalCount());
    }
}
