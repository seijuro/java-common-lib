package com.github.seijuro.common.scrap.publicdata.specinfo;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIErrorResponse;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResponse;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResponseParser;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class SpecificationInfoAPIResponseParser extends PublicDataAPIResponseParser {
    static class ReservedProperty {
        //  product

    }

    private List<SpecificationInfo> specificationInfos = null;
    private SpecificationInfo.Builder productStdInfoBuilder = null;

    /**
     * C'tor
     *
     * @param type
     * @param input
     */
    public SpecificationInfoAPIResponseParser(InputType type, String input) {
        super(type, input);
    }

    @Override
    protected boolean handleTagBegin(String tag) {
        if (!super.handleTagBegin(tag)) {
            if (SpecificationInfoProperty.ITEMS.equals(tag)) {
                this.specificationInfos = new ArrayList<>(100);

                return true;
            }
            else if (SpecificationInfoProperty.ITEM.equals(tag)) {
                this.productStdInfoBuilder = new SpecificationInfo.Builder();

                return true;
            }

            return false;
        }

        return true;
    }

    @Override
    protected boolean handleTagEnd(String tag, String value) {
        if (!super.handleTagEnd(tag, value)) {
            if (SpecificationInfoPropertyUtils.Item.contains(tag)) {
                int code = SpecificationInfoPropertyUtils.Item.getCode(tag, Integer.MIN_VALUE);

                switch (code) {

                }
            }
            else if (SpecificationInfoProperty.ITEMS.equals(tag)) {
                return true;
            }
            else if (SpecificationInfoProperty.ITEM.equals(tag)) {
                assert (this.productStdInfoBuilder != null);

                this.specificationInfos.add(this.productStdInfoBuilder.build());
                this.productStdInfoBuilder = null;

                return true;
            }

            return false;
        }

        return true;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        if (hasError()) {
            this.response = new PublicDataAPIErrorResponse(this.reasonCode, this.errorMsg, this.authMsg);
        }
        else {
            SpeficiationInfoResponse res = new SpeficiationInfoResponse(this.resultCode, this.resultMsg, this.pageNo, this.numberOfRows, this.totalCount);
            res.setSpecificationInfos(this.specificationInfos);

            this.response = res;
        }
    }


}
