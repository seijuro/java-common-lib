package com.github.seijuro.common.webscrap.publicapi.parser;

import com.github.seijuro.common.xml.parser.XMLSAXParser;

public class StandarInfoAPIResponseParser extends XMLSAXParser {
    /**
     * C'tor
     *
     * @param type
     * @param input
     */
    public StandarInfoAPIResponseParser(InputType type, String input) {
        super(type, input);
    }

    @Override
    protected void handleTagBegin(String tag) {

    }

    @Override
    protected void handleTagEnd(String tag, String value) {

    }
}
