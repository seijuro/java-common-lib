package com.github.seijuro.common.scrap.publicdata.recall;

import com.github.seijuro.common.scrap.publicdata.PublicDataConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RecallAPIConfig extends PublicDataConfig {
    public static final String PARAM_SEARCH = "model_query";
    public static final String PARAM_FIELD_VISIBILITY = "model_query_fields";
    public static final String PARAM_DISTINCT = "model_query_distinct";
    public static final String PARAM_PAGEABLE = "model_query_pageable";

    public static class ConditionUtils {
        public static JSONObject cretate(Comparator comparator, RecallProperty.Field field, Object value) {
            JSONObject jsonCondition = new JSONObject();

            if (value != null) {
                if (comparator == Comparator.EQUAL) {
                    jsonCondition.put(field.toString(), value);
                }
                else if (comparator == Comparator.LIKE  ||
                        comparator == Comparator.GREATER_THAN ||
                        comparator == Comparator.LESS_THAN ||
                        comparator == Comparator.GREATER_THAN_OR_EQUALS ||
                        comparator == Comparator.LESS_THAN_OR_EQUALS ||
                        comparator == Comparator.NOT_EQUALS) {
                    JSONObject jsonValue = new JSONObject();
                    jsonValue.put(comparator.toOperatorString(), value);
                    jsonCondition.put(field.toString(), jsonValue);
                }
            }
            else if (comparator == Comparator.IS_NULL) {
                jsonCondition.put(field.toString(), null);
            }
            else if (comparator == Comparator.IS_NOT_NULL) {
                JSONObject jsonValue = new JSONObject();
                jsonValue.put(comparator.toOperatorString(), null);
                jsonCondition.put(field.toString(), jsonValue);
            }

            return jsonCondition;
        }

        public static JSONObject combine(Comparator comparator, Set<JSONObject> conds) {
            JSONObject jsonCombined = new JSONObject();

            if ((comparator == Comparator.OR || comparator == Comparator.AND) &&
                    conds.size() > 2) {
                JSONArray jsonConds = new JSONArray();

                Iterator<JSONObject> iter = conds.iterator();

                while (iter.hasNext()) {
                    jsonConds.add(iter.next());
                }

                jsonCombined.put(comparator.toOperatorString(), jsonConds);
            }

            return jsonCombined;
        }
    }

    private enum Comparator {
        EQUAL(""),
        NOT_EQUALS("$ne"),
        LIKE("$regex"),
        GREATER_THAN("$gt"),
        LESS_THAN("$lt"),
        GREATER_THAN_OR_EQUALS("$gte"),
        LESS_THAN_OR_EQUALS("$lte"),
        IS_NOT_NULL("$ne"),
        IS_NULL(""),
        AND("$and"),
        OR("$or");

        private final String operator;

        Comparator(String op) {
            this.operator = op;
        }

        public String toOperatorString() {
            return this.operator;
        }
    }

    enum Direction {
        ASC(1),
        DESC(-1);

        private final int value;

        Direction(int $value) {
            this.value = $value;
        }

        public int toInt() {
            return new Integer(this.value);
        }
    }

    enum Visibility {
        VISIBLE(1),
        INVISIBLE(0);

        private final int flag;

        Visibility(int $flag) {
            this.flag = $flag;
        }

        public int toInt() {
            return this.flag;
        }
    }

    private enum SortOrder {
        PROPERTY("property"),
        DIRECTION("direction");

        /**
         * Instance Property
         */
        private final String fieldName;

        /**
         * C'tor
         *
         * @param name
         */
        SortOrder(String name) {
            this.fieldName = name;
        }

        @Override
        public String toString() {
            return this.fieldName;
        }
    }

    private enum Pageable {
        ENABLE("enable"),
        PAGE_NUMBER("pageNumber"),
        PAGE_SIZE("pageSize"),
        SORT_ORDERS("sortOrders");

        /**
         * Instance Property
         */
        private final String fieldName;

        /**
         * C'tor
         *
         * @param name
         */
        Pageable(String name) {
            this.fieldName = name;
        }

        @Override
        public String toString() {
            return this.fieldName;
        }
    }

    public RecallAPIConfig() {
        super();
    }

    protected JSONObject getPageableJSONObject() {
        JSONObject jsonPageable = (JSONObject)get(PARAM_PAGEABLE);

        if (!(jsonPageable instanceof JSONObject)) {
            jsonPageable = new JSONObject();

            this.put(PARAM_PAGEABLE, jsonPageable);
        }

        return jsonPageable;
    }

    protected JSONObject getFieldVisibilityJSONPObject() {
        JSONObject jsonVisibility = (JSONObject)get(PARAM_FIELD_VISIBILITY);

        if (!(jsonVisibility instanceof JSONObject)) {
            jsonVisibility = new JSONObject();

            this.put(PARAM_FIELD_VISIBILITY, jsonVisibility);
        }

        return jsonVisibility;
    }

    public RecallAPIConfig setPageableEnabled(boolean flag) {
        JSONObject jsonPageable = getPageableJSONObject();
        jsonPageable.put(Pageable.ENABLE.toString(), new Boolean(flag));

        return this;
    }

    public RecallAPIConfig setPageablePageNumber(int page) {
        JSONObject jsonPageable = getPageableJSONObject();
        jsonPageable.put(Pageable.PAGE_NUMBER.toString(), new Integer(page > 0 ? page : 0));

        return this;
    }

    public RecallAPIConfig setPageablePageSize(int size) {
        JSONObject jsonPageable = getPageableJSONObject();
        jsonPageable.put(Pageable.PAGE_SIZE.toString(), new Integer(size > 0 ? size : 10));

        return this;
    }

    public RecallAPIConfig setPageableSortOrders(Map<RecallProperty.Field, Direction> orders) {
        JSONObject jsonPageable = getPageableJSONObject();
        JSONArray jsonOrders = new JSONArray();

        for (Map.Entry<RecallProperty.Field, Direction> order : orders.entrySet()) {
            JSONObject jsonOrder = new JSONObject();
            jsonOrder.put(SortOrder.PROPERTY.toString(), order.getKey().toString());
            jsonOrder.put(SortOrder.DIRECTION.toString(), new Integer(order.getValue().toInt()));

            jsonOrders.add(jsonOrder);
        }

        jsonPageable.put(Pageable.SORT_ORDERS.toString(), jsonOrders);

        return this;
    }

    public RecallAPIConfig setFieldDistinct(RecallProperty.Field field) {
        this.put(PARAM_DISTINCT, field.toString());

        return this;
    }

    public RecallAPIConfig setFieldVisibility(Set<RecallProperty.Field> fields, Visibility visibility) {
        Iterator<RecallProperty.Field> iter = fields.iterator();
        JSONObject jsonVisibility = new JSONObject();
        Integer intVisibility = new Integer(visibility.toInt());

        while (iter.hasNext()) {
            RecallProperty.Field field = iter.next();
            jsonVisibility.put(field.toString(), intVisibility);
        }

        this.put(PARAM_FIELD_VISIBILITY, jsonVisibility);

        return this;
    }
}
