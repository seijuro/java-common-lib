package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.xml.parser.XMLSAXParser;
import lombok.AccessLevel;
import lombok.Getter;
import org.xml.sax.SAXException;

public abstract class PublicDataAPIResponseParser extends XMLSAXParser {
    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PROTECTED)
    private String resultCode = null;
    @Getter(AccessLevel.PROTECTED)
    private String resultMessage = null;
    @Getter(AccessLevel.PROTECTED)
    private int numberOfRows = Integer.MIN_VALUE;
    @Getter(AccessLevel.PROTECTED)
    private int pageNo = Integer.MIN_VALUE;
    @Getter(AccessLevel.PROTECTED)
    private int totalCount = Integer.MIN_VALUE;

    //  error
    protected boolean hasError = false;
    protected String errorMsg = null;
    protected String authMsg = null;
    protected String reasonCode = null;

    private PublicDataAPIResult result = null;

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
    protected boolean handleTagBegin(String tag) {
        if (PublicDataPropertyUtils.Result.contains(tag)) {
            int code = PublicDataPropertyUtils.Result.getCode(tag, Integer.MIN_VALUE);

            assert (code != Integer.MIN_VALUE);

            return true;
        }
        else if (PublicDataPropertyUtils.Error.contains(tag)) {
            int code = PublicDataPropertyUtils.Error.getCode(tag, Integer.MIN_VALUE);

            assert (code != Integer.MIN_VALUE);

            return true;
        }

        return false;
    }

    @Override
    protected boolean handleTagEnd(String tag, String value) {
        //  tags related to 'result'
        if (PublicDataPropertyUtils.Result.contains(tag)) {
            int code = PublicDataPropertyUtils.Result.getCode(tag, Integer.MIN_VALUE);

            assert (code != Integer.MIN_VALUE);

            switch (code) {
                case PublicDataProperty.ResultCode.RC_NUM_OF_ROWS:
                    this.numberOfRows = Integer.parseInt(value);
                    return true;
                case PublicDataProperty.ResultCode.RC_PAGE_NO:
                    this.pageNo = Integer.parseInt(value);
                    return true;
                case PublicDataProperty.ResultCode.RC_TOTAL_COUNT:
                    this.totalCount = Integer.parseInt(value);
                    return true;
                case PublicDataProperty.ResultCode.RC_RESULT_CODE:
                    this.resultCode = value;
                    return true;
                case PublicDataProperty.ResultCode.RC_RESULT_MESSAGE:
                    this.resultMessage = value;
                    return true;

                default:
                    break;
            }
        }
        //  tags related to 'error'
        else if (PublicDataPropertyUtils.Error.contains(tag)) {
            int code = PublicDataPropertyUtils.Error.getCode(tag, Integer.MIN_VALUE);

            assert (code != Integer.MIN_VALUE);

            this.hasError = true;

            switch (code) {
                case PublicDataProperty.ErrorCode.ERROR_MESSAGE:
                    this.errorMsg = value;
                    return true;
                case PublicDataProperty.ErrorCode.REASON_CODE:
                    this.reasonCode = value;
                    return true;
                case PublicDataProperty.ErrorCode.AUTHENTICATION_MESSAGE:
                    this.authMsg = value;
                    return true;

                default:
                    break;
            }
        }

        return false;
    }

    /**
     * endDocument
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        //  default impl.
        this.result = createResult();
    }

    /**
     * create result
     * @return
     */
    protected PublicDataAPIResult createResult() {
        if (!hasError()) {
            return new PublicDataAPIResult(this.resultCode, this.resultMessage, this.pageNo, this.numberOfRows, this.totalCount);
        }

        return new PublicDataAPIErrorResult(this.reasonCode, this.errorMsg, this.authMsg);
    }

    public boolean hasError() {
        return this.hasError;
    }

    public PublicDataAPIResult getResult() {
        return this.result;
    }
}
