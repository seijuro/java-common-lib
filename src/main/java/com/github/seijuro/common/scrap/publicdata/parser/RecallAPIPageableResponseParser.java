package com.github.seijuro.common.scrap.publicdata.parser;

import com.github.seijuro.common.InputType;
import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIErrorResult;
import com.github.seijuro.common.scrap.publicdata.result.RecallAPIPageableResult;
import com.google.gson.Gson;

public class RecallAPIPageableResponseParser extends RecallAPIResponseParser {
    /**
     * C'tor
     */
    public RecallAPIPageableResponseParser() {
        super();
    }

    @Override
    public void parse(InputType type, String input) {
        try {
            Gson gson = new Gson();
            RecallAPIPageableResult.Builder builder = gson.fromJson(input, RecallAPIPageableResult.Builder.class);

            assert (builder != null);

            setResult(builder.build());
        }
        catch (Exception excp) {
            excp.printStackTrace();

            setResult(new PublicDataAPIErrorResult(null, excp.getMessage(), null));
        }
    }


}
