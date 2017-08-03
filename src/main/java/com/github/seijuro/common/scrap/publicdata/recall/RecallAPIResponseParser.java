package com.github.seijuro.common.scrap.publicdata.recall;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIErrorResult;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResponseJSONParser;
import com.google.gson.Gson;

import java.util.Arrays;

public class RecallAPIResponseParser extends PublicDataAPIResponseJSONParser {
    /**
     * C'tor
     *
     * @param type
     * @param input
     */
    public RecallAPIResponseParser(InputType type, String input) {
        super(type, input);
    }

    @Override
    public void parse() {
        try {
            Gson gson = new Gson();

            Recall[] recalls = gson.fromJson(getInput(), Recall[].class);

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
