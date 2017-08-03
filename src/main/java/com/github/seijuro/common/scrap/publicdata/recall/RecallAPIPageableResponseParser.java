package com.github.seijuro.common.scrap.publicdata.recall;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIErrorResult;
import com.google.gson.Gson;

public class RecallAPIPageableResponseParser extends RecallAPIResponseParser {
    /**
     * C'tor
     *
     * @param type
     * @param input
     */
    public RecallAPIPageableResponseParser(InputType type, String input) {
        super(type, input);
    }

    @Override
    public void parse() {
        try {
            Gson gson = new Gson();
            RecallAPIPageableResult.Builder builder = gson.fromJson(getInput(), RecallAPIPageableResult.Builder.class);

            assert (builder != null);

            setResult(builder.build());
        }
        catch (Exception excp) {
            excp.printStackTrace();

            setResult(new PublicDataAPIErrorResult(null, excp.getMessage(), null));
        }
    }

    
}
