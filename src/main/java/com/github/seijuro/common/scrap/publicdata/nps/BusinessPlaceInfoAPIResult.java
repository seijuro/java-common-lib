package com.github.seijuro.common.scrap.publicdata.nps;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResult;


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
    public BusinessPlaceInfoAPIResult(String $resultCode, String $resultMesg, int $pageNo, int $numOfRows, int $totalCount) {
        super($resultCode, $resultMesg, $pageNo, $numOfRows, $totalCount);
    }

    /**
     * C'tor
     *
     * @param parent
     * @param <T>
     */
    public <T extends PublicDataAPIResult> BusinessPlaceInfoAPIResult(T parent) {
        super(parent.getResultCode(), parent.getResultMessage(), parent.getPageNos(), parent.getNumberOfRows(), parent.getTotalCount());
    }
}
