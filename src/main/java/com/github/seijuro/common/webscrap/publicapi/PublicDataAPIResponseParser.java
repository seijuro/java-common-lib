package com.github.seijuro.common.webscrap.publicapi;

import com.github.seijuro.common.xml.parser.XMLSAXParser;
import org.xml.sax.SAXException;

public abstract class PublicDataAPIResponseParser extends XMLSAXParser {
    /**
     * Instance Properties
     */
    protected boolean hasError = false;
    protected String errorMsg = null;
    protected String authMsg = null;
    protected int reasonCode = -1;
    protected PublicDataAPIErrorResponse errorResponse = null;

    /**
     * C'tor
     *
     * @param type
     * @param input
     */
    public PublicDataAPIResponseParser(InputType type, String input) {
        super(type, input);
    }

    @Override
    protected void handleTagBegin(String tag) {
    }

    @Override
    protected void handleTagEnd(String tag, String value) {
        if (tag.equals(CommonProperty.Error.ERROR_MESSAGE)) {
            this.errorMsg = value;
            this.hasError = true;
        }
        else if (tag.equals(CommonProperty.Error.REASON_CODE)) {
            this.reasonCode = Integer.parseInt(value);
        }
        else if (tag.equals(CommonProperty.Error.AUTHENTICATION_MESSAGE)) {
            this.authMsg = value;
        }
    }

    /**
     * endDocument
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        if (hasError()) {
            this.errorResponse = new PublicDataAPIErrorResponse(this.reasonCode, this.errorMsg);

            if (this.authMsg != null) {
                this.errorResponse.setOther(CommonProperty.Error.AUTHENTICATION_MESSAGE, this.authMsg);
            }
        }
    }

    public boolean hasError() {
        return this.hasError;
    }

    public PublicDataAPIErrorResponse getErrorResponse() {
        return this.errorResponse;
    }
}
