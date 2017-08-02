package com.github.seijuro.common.scrap.publicdata.nps;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResponse;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIResponseParser;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class BusinessPlaceInfoAPIResponseParser extends PublicDataAPIResponseParser{
    /**
     * Instance Properties
     */
    protected BusinessPlaceInfo.Builder infoBuilder = null;
    protected List<BusinessPlaceInfo> infoList = null;

    /**
     * C'tor
     *
     * @param type
     * @param input
     */
    public BusinessPlaceInfoAPIResponseParser(InputType type, String input) {
        super(type, input);
    }

    @Override
    protected boolean handleTagBegin(String tag) {
        if (!super.handleTagBegin(tag)) {
            if (BusinessPlaceInfoPropertyUtils.Item.contains(tag)) {
                return true;
            }
            else if (BusinessPlaceInfoProperty.ITEM.equals(tag)) {
                //  create builder object
                this.infoBuilder = new BusinessPlaceInfo.Builder();

                return true;
            }
            else if (BusinessPlaceInfoProperty.ITEMS.equals(tag)) {
                //  create container
                this.infoList = new ArrayList<>();

                return true;
            }
            else if (BusinessPlaceInfoProperty.BODY.equals(tag)) {
                // do nothing
                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean handleTagEnd(String tag, String value) {
        if (!super.handleTagEnd(tag, value)) {
            if (BusinessPlaceInfoPropertyUtils.Item.contains(tag)) {
                int code = BusinessPlaceInfoPropertyUtils.Item.getCode(tag, Integer.MIN_VALUE);

                assert (code != Integer.MIN_VALUE);
                assert (this.infoBuilder != null);

                switch (code) {
                    case BusinessPlaceInfoProperty.ItemCode.IC_CREATED_YM:
                        this.infoBuilder.setCreatedDateYM(value);
                        return true;
                    case BusinessPlaceInfoProperty.ItemCode.IC_ID:
                        this.infoBuilder.setID(value);
                        return true;
                    case BusinessPlaceInfoProperty.ItemCode.IC_BUSINESSPLACE_NAME:
                        this.infoBuilder.setName(value);
                        return true;
                    case BusinessPlaceInfoProperty.ItemCode.IC_REGISTRATION_NUMBER:
                        this.infoBuilder.setRegistrationNumber(value);
                        return true;
                    case BusinessPlaceInfoProperty.ItemCode.IC_ADDRESS_STREET:
                        this.infoBuilder.setAddressStreet(value);
                        return true;
                    case BusinessPlaceInfoProperty.ItemCode.IC_STATUS_CODE:
                        this.infoBuilder.setStatusCode(value);
                        return true;
                    case BusinessPlaceInfoProperty.ItemCode.IC_DIVISION_CODE:
                        this.infoBuilder.setDivisionCode(value);
                        return true;
                    case BusinessPlaceInfoProperty.ItemCode.IC_ADDRESS_DG:
                        this.infoBuilder.setAddressCodeDG(value);
                        return true;
                    case BusinessPlaceInfoProperty.ItemCode.IC_ADDRESS_SGG:
                        this.infoBuilder.setAddressCodeSGG(value);
                        return true;
                    case BusinessPlaceInfoProperty.ItemCode.IC_ADDRESS_EMD:
                        this.infoBuilder.setAddressCodeEMD(value);
                        return true;

                    default:
                        break;
                }
            }
            else if (BusinessPlaceInfoProperty.ITEM.equals(tag)) {
                assert (this.infoList != null);
                assert (this.infoBuilder != null);

                this.infoList.add(this.infoBuilder.build());

                this.infoBuilder = null;

                return true;
            }
            else if (BusinessPlaceInfoProperty.ITEMS.equals(tag)) {
                //  do nothing

                return true;
            }
            else if (BusinessPlaceInfoProperty.BODY.equals(tag)) {
                //  do nothing

                return true;
            }
        }

        return false;
    }

    @Override
    protected PublicDataAPIResponse createResponse() {
        return super.createResponse();
    }
}
