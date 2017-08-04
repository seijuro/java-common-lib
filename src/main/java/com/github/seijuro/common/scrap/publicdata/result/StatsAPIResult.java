package com.github.seijuro.common.scrap.publicdata.result;

import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIResult;

public class StatsAPIResult extends PublicDataAPIResult {

    /**
     * C'tor
     *
     * @param $resultCode
     * @param $resultMesg
     * @param $pageNo
     * @param $numOfRows
     * @param $totalCount
     */
    public StatsAPIResult(String $resultCode, String $resultMesg, int $pageNo, int $numOfRows, int $totalCount) {
        super($resultCode, $resultMesg, $pageNo, $numOfRows, $totalCount);
    }

    public <T extends PublicDataAPIResult> StatsAPIResult(T parent) {
        super(parent.getResultCode(), parent.getResultMessage(), parent.getPageNo(), parent.getNumberOfRows(), parent.getTotalCount());
    }
}
