package com.github.seijuro.common.scrap.publicdata.nps;

import java.util.ArrayList;
import java.util.List;

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
}
