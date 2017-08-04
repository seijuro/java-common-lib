package com.github.seijuro.common.scrap.publicdata.parser;

import com.github.seijuro.common.scrap.publicdata.result.PublicDataAPIResult;
import com.github.seijuro.common.scrap.publicdata.property.NPSProperty;
import com.github.seijuro.common.scrap.publicdata.property.NPSPropertyUtils;
import com.github.seijuro.common.scrap.publicdata.result.item.Stats;
import com.github.seijuro.common.scrap.publicdata.result.StatsAPIResult;

import java.util.ArrayList;
import java.util.List;

public class StatsAPIResponseParser extends PublicDataAPIResponseXMLParser {
    /**
     * Instance Properties
     */
    protected Stats.Builder dataBuilder = null;
    protected List<Stats> dataList = null;

    /**
     * C'tor
     */
    public StatsAPIResponseParser() {
        super();
    }

    @Override
    protected boolean handleTagBegin(String tag) {
        if (!super.handleTagBegin(tag)) {
            if (NPSPropertyUtils.Item.contains(tag)) {
                int code = NPSPropertyUtils.Item.getCode(tag, Integer.MIN_VALUE);

                assert code != Integer.MIN_VALUE;

                switch (code) {
                    case NPSProperty.ItemCode.Stats.IC_MONTHLY_EMPLOYMENT:
                        return true;
                    case NPSProperty.ItemCode.Stats.IC_MONTHLY_RETIREMENT:
                        return true;

                    default:
                        break;
                }
            }
            else if (NPSProperty.ITEM.equals(tag)) {
                this.dataBuilder = (Stats.Builder)(NPSDataBuilderFactory.create(Stats.Builder.class));

                return true;
            }
            else if (NPSProperty.ITEMS.equals(tag)) {
                // do nothing

                return true;
            }
            else if (NPSProperty.BODY.equals(tag)) {
                this.dataList = new ArrayList<>();

                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean handleTagEnd(String tag, String value) {
        if (!super.handleTagEnd(tag, value)) {
            if (NPSPropertyUtils.Item.contains(tag)) {
                int code = NPSPropertyUtils.Item.getCode(tag, Integer.MIN_VALUE);

                assert code != Integer.MIN_VALUE;

                switch (code) {
                    case NPSProperty.ItemCode.Stats.IC_MONTHLY_EMPLOYMENT:
                        this.dataBuilder.setMonthlyEmployment(value);
                        return true;
                    case NPSProperty.ItemCode.Stats.IC_MONTHLY_RETIREMENT:
                        this.dataBuilder.setMonthlyRetirement(value);
                        return true;

                    default:
                        break;
                }
            }
            else if (NPSProperty.ITEM.equals(tag)) {
                this.dataList.add(this.dataBuilder.build());
                this.dataBuilder = null;

                return true;
            }
            else if (NPSProperty.ITEMS.equals(tag)) {
                // do nothing

                return true;
            }
            else if (NPSProperty.BODY.equals(tag)) {
                //  do nothing

                return true;
            }
        }

        return false;
    }

    @Override
    protected PublicDataAPIResult createResult() {
        if (!hasError()) {
            PublicDataAPIResult result = new StatsAPIResult(super.createResult());

            return result;
        }

        return super.createResult();
    }
}