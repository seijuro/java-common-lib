package com.github.seijuro.common.scrap.publicdata.services.recall;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResult;
import lombok.ToString;

import java.util.List;
import java.util.function.Consumer;

@ToString
public class RecallAPIResult extends PublicDataAPIResult {
    /**
     * C'tor
     *
     * @param $resultCode
     * @param $resultMesg
     * @param $pageNo
     * @param $numOfRows
     * @param $totalCount
     */
    public RecallAPIResult(String $resultCode, String $resultMesg, int $pageNo, int $numOfRows, int $totalCount) {
        super($resultCode, $resultMesg, $pageNo, $numOfRows, $totalCount);
    }

    /**
     * Implements IPrettyPrint
     *
     * @param consumer
     */
    @Override
    public void prettyPrint(Consumer<String> consumer) {
        super.prettyPrint(consumer);
        List<Recall> results = getData(Recall.class);

        consumer.accept("[result of recall API] (pageable : false)\n");
        for (Recall recall : results) {
            recall.prettyPrint(consumer);
        }
    }
}
