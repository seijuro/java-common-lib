package com.github.seijuro.common.scrap.publicdata.services.nps.detail;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResult;
import com.github.seijuro.common.scrap.publicdata.services.nps.normal.BusinessPlaceInfoAPIResult;

public class BusinessPlaceDetailInfoAPIResult extends BusinessPlaceInfoAPIResult {
    /**
     * C'tor
     *
     * @param $resultCode
     * @param $resultMesg
     * @param $pageNo
     * @param $numOfRows
     * @param $totalCount
     */
    public BusinessPlaceDetailInfoAPIResult(String $resultCode, String $resultMesg, int $pageNo, int $numOfRows, int $totalCount) {
        super($resultCode, $resultMesg, $pageNo, $numOfRows, $totalCount);
    }

    /**
     * C'tor
     *
     * @param parent
     * @param <T>
     */
    public <T extends PublicDataAPIResult> BusinessPlaceDetailInfoAPIResult(T parent) {
        super(parent.getResultCode(), parent.getResultMessage(), parent.getPageNo(), parent.getNumberOfRows(), parent.getTotalCount());
    }
}
