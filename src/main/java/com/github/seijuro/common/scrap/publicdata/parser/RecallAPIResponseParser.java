package com.github.seijuro.common.scrap.publicdata.parser;

import com.github.seijuro.common.InputType;
import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIErrorResult;
import com.github.seijuro.common.scrap.publicdata.result.item.Recall;
import com.github.seijuro.common.scrap.publicdata.result.RecallAPIResult;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.Arrays;

public class RecallAPIResponseParser extends PublicDataAPIResponseJSONParser {
    /**
     * C'tor
     */
    public RecallAPIResponseParser() {
        super();
    }

    @Test
    @Override
    public void parse(InputType type, String input) {
        try {
            Gson gson = new Gson();

            Recall[] recalls = gson.fromJson(input, Recall[].class);

            String resultMessage = "";
            String resultCode = "";
            int pageIndex = 0;
            int pageSize = recalls.length;
            int totalCount = recalls.length;

            RecallAPIResult result = new RecallAPIResult(
                    resultCode,
                    resultMessage,
                    pageIndex,
                    pageSize,
                    totalCount);
            assert (recalls != null);

            result.addData(Arrays.asList(recalls));
            setResult(result);
        }
        catch (Exception excp) {
            excp.printStackTrace();

            setResult(new PublicDataAPIErrorResult(null, excp.getMessage(), null));
        }
    }
}
