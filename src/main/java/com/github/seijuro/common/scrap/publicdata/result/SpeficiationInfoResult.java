package com.github.seijuro.common.scrap.publicdata.result;

import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIResult;
import com.github.seijuro.common.scrap.publicdata.result.item.SpecificationInfo;

import java.util.List;

public class SpeficiationInfoResult extends PublicDataAPIResult {
    private List<SpecificationInfo> infoList = null;
    /**
     * C'tor
     *
     * @param $resultCode
     * @param $resultMesg
     * @param $pageNo
     * @param $numOfRows
     * @param $totalCount
     */
    public SpeficiationInfoResult(String $resultCode, String $resultMesg, Integer $pageNo, Integer $numOfRows, Integer $totalCount) {
        super($resultCode, $resultMesg, $pageNo, $numOfRows, $totalCount);
    }

    public <T extends PublicDataAPIResult> SpeficiationInfoResult(T parent) {
        super(parent.getResultCode(), parent.getResultMessage(), parent.getPageNo(), parent.getNumberOfRows(), parent.getTotalCount());
    }
}
