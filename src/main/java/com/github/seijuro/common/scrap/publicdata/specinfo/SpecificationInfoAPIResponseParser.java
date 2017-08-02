package com.github.seijuro.common.scrap.publicdata.specinfo;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResponseParser;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResult;

import java.util.ArrayList;
import java.util.List;

public class SpecificationInfoAPIResponseParser extends PublicDataAPIResponseParser {
    /**
     * Instance Properties
     */
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
            else if (SpecificationInfoProperty.BODY.equals(tag)) {
                //  do nothing

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
                    case SpecificationInfoProperty.ItemCode.IC_BSNS_DIV_NAME:
                        this.productStdInfoBuilder.setBusinessDivisionName(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_REF_NO:
                        this.productStdInfoBuilder.setReferenceNo(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_PRODUCT_NAME:
                        this.productStdInfoBuilder.setProductName(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_ORDER_INSTR_NAME:
                        this.productStdInfoBuilder.setOrderingInstName(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_DEMAND_INST_NAME:
                        this.productStdInfoBuilder.setDemandInstName(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_ASSIGN_BUDGET_AMOUNT:
                        this.productStdInfoBuilder.setAssignBudgetAmount(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_RECEIPT_DATE:
                        this.productStdInfoBuilder.setReceiptDate(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_OPITION_REG_CLOSE_DATE:
                        this.productStdInfoBuilder.setRegisterOptionDueDate(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_OFFICIAL_TELNO:
                        this.productStdInfoBuilder.setOfficialTel(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_OFFICIAL_NAME:
                        this.productStdInfoBuilder.setOfficalName(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_SW_BIZOBJ_YN:
                        this.productStdInfoBuilder.setIsSWBusiness(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_DELIVERY_TIMELIMIT_DATE:
                        this.productStdInfoBuilder.setDeliveryDueDate(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_DELIVERY_DAY_NUM:
                        this.productStdInfoBuilder.setDeliveryDayNum(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_BEFORRE_SPEC_REG_NO:
                        this.productStdInfoBuilder.setSpecificationRegNo(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_SPEC_DOCFILE_URL_1:
                        this.productStdInfoBuilder.setSpecificationDocFileURL1(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_SPEC_DOCFILE_URL_2:
                        this.productStdInfoBuilder.setSpecificationDocFileURL2(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_SPEC_DOCFILE_URL_3:
                        this.productStdInfoBuilder.setSpecificationDocFileURL3(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_SPEC_DOCFILE_URL_4:
                        this.productStdInfoBuilder.setSpecificationDocFileURL4(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_SPEC_DOCFILE_URL_5:
                        this.productStdInfoBuilder.setSpecificationDocFileURL5(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_PRODUCT_DETAIL_LIST:
                        this.productStdInfoBuilder.setProductDetails(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_REG_DATE:
                        this.productStdInfoBuilder.setRegDate(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_CHANGE_DATE:
                        this.productStdInfoBuilder.setChangedDate(value);
                        return true;
                    case SpecificationInfoProperty.ItemCode.IC_BID_NOTICE_NO_LIST:
                        this.productStdInfoBuilder.setBidNoticeNoList(value);
                        return true;

                    default:
                        break;
                }
            }
            else if (SpecificationInfoProperty.ITEM.equals(tag)) {
                assert (this.specificationInfos != null);
                assert (this.productStdInfoBuilder != null);

                this.specificationInfos.add(this.productStdInfoBuilder.build());
                this.productStdInfoBuilder = null;

                return true;
            }
            else if (SpecificationInfoProperty.ITEMS.equals(tag)) {
                //  do nothing
                return true;
            }
            else if (SpecificationInfoProperty.BODY.equals(tag)) {
                //  do nothing
                return true;
            }

            return false;
        }

        return true;
    }

    @Override
    protected PublicDataAPIResult createResult() {
        if (!hasError()) {
            PublicDataAPIResult result = new SpeficiationInfoResult(this.resultCode, this.resultMsg, this.pageNo, this.numberOfRows, this.totalCount);
            result.addData(this.specificationInfos);

            return result;
        }

        return super.createResult();
    }
}
