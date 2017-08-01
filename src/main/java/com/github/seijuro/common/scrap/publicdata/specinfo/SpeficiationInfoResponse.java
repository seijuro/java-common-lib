package com.github.seijuro.common.scrap.publicdata.specinfo;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResponse;

import java.util.List;

public class SpeficiationInfoResponse extends PublicDataAPIResponse {
    private List<SpecificationInfo> infos = null;
    /**
     * C'tor
     *
     * @param $resultCode
     * @param $resultMesg
     * @param $pageNo
     * @param $numOfRows
     * @param $totalCount
     */
    public SpeficiationInfoResponse(String $resultCode, String $resultMesg, int $pageNo, int $numOfRows, int $totalCount) {
        super($resultCode, $resultMesg, $pageNo, $numOfRows, $totalCount);
    }

    public SpeficiationInfoResponse setSpecificationInfos(List<SpecificationInfo> $infos) {
        this.infos = infos;

        return this;
    }
}
