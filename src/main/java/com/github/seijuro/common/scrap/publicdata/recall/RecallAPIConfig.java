package com.github.seijuro.common.scrap.publicdata.recall;

import com.github.seijuro.common.IJSONConvertable;
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

    /**
     * Condition
     */
    public static class Condition implements IJSONConvertable {
        /**
         * interface for composite
         */
        private interface Opr {
            String toOprString();
        }

        /**
         * Comparator
         *
         * comparator contains 'binary' operator, such as EQUAL, NOT_EQUALS, LIKE, GREATER_THAN, etc ...
         */
        public enum Comparator implements Opr {
            EQUAL(""),
            NOT_EQUALS("$ne"),
            LIKE("$regex"),
            GREATER_THAN("$gt"),
            LESS_THAN("$lt"),
            GREATER_THAN_OR_EQUALS("$gte"),
            LESS_THAN_OR_EQUALS("$lte"),
            IS_NOT_NULL("$ne"),
            IS_NULL("");

            private final String operator;

            Comparator(String opr) {
                this.operator = opr;
            }

            @Override
            public String toOprString() {
                return this.operator;
            }
        }

        /**
         * Combiner
         *
         * comparator contains 'and', 'or' operator
         */
        public enum Combiner implements Opr {
            AND("$and"),
            OR("$or");

            private final String operator;

            Combiner(String opr) {
                this.operator = opr;
            }

            @Override
            public String toOprString() {
                return this.operator;
            }
        }

        /**
         * Instance Properties
         */
        private final Opr opr;
        private final Field field;
        private final Object value;

        /**
         * C'tor
         *
         * @param $opr
         * @param $field
         * @param $value
         */
        public Condition (Comparator $opr, Field $field, Object $value) {
            this.opr = $opr;
            this.field = $field;
            this.value = $value;
        }

        /**
         * C'tor
         *
         * @param $opr
         * @param conds
         */
        public Condition (Combiner $opr, Set<Condition> conds) {
            this.opr = $opr;
            this.field = null;
            this.value = conds;
        }

        /**
         * implement IJSONConvertable interface.
         *
         * @return
         */
        @Override
        public JSONObject toJSONObject() {
            JSONObject jsonCondition = new JSONObject();

            if (this.opr instanceof Comparator) {
                if (this.value != null) {
                    if (this.opr == Comparator.EQUAL) {
                        jsonCondition.put(field.toString(), value);
                    } else if (this.opr == Comparator.LIKE ||
                            this.opr == Comparator.GREATER_THAN ||
                            this.opr == Comparator.LESS_THAN ||
                            this.opr == Comparator.GREATER_THAN_OR_EQUALS ||
                            this.opr == Comparator.LESS_THAN_OR_EQUALS ||
                            this.opr == Comparator.NOT_EQUALS) {
                        JSONObject jsonValue = new JSONObject();
                        jsonValue.put(this.opr.toOprString(), value);
                        jsonCondition.put(this.field.toString(), jsonValue);
                    }
                } else if (this.opr == Comparator.IS_NULL) {
                    jsonCondition.put(this.field.toString(), null);
                } else if (this.opr == Comparator.IS_NOT_NULL) {
                    JSONObject jsonValue = new JSONObject();
                    jsonValue.put(this.opr.toOprString(), null);
                    jsonCondition.put(this.field.toString(), jsonValue);
                }
            }
            else if (this.opr instanceof Combiner) {
                if (this.value instanceof Set) {
                    Set<Condition> conds = (Set<Condition>)(this.value);

                    if (conds.size() > 1) {
                        JSONArray jsonConds = new JSONArray();

                        Iterator<Condition> iter = conds.iterator();

                        while (iter.hasNext()) {
                            jsonConds.add(iter.next().toJSONObject());
                        }

                        jsonCondition.put(this.opr.toOprString(), jsonConds);
                    }
                }
            }

            return jsonCondition;
        }

        /**
         * implements <code>hashCode</code> method.
         * <code>Condition</code> instance can be used with HashSet, HashMap, etc ...
         *
         * @return
         */
        @Override
        public int hashCode() {
            int code = 17;

            code = code * this.opr.toOprString().hashCode() << 31 + this.field.toString().hashCode();
            code = code << 31 + (this.value == null ? 0 : this.value.hashCode());

            return code;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Condition) {
                Condition rhs = (Condition)obj;

                if (this.opr != rhs) return false;
                if (this.field == null) {
                    if (rhs != null) return false;
                }
                else if (!this.field.equals(rhs.field)) return false;
                else if (this.value == null) {
                    if (rhs.value != null) return false;
                }
                else if (!this.value.equals(rhs.value)) return false;

                return true;
            }

            return false;
        }
    }

    /**
     * enum Field
     */
    public enum Field {
        IDX(RecallProperty.FieldName.IDX),
        COUNTRY_OF_MANUFACTURE(RecallProperty.FieldName.COUNTRY_OF_MANUFACTURE),
        PRODUCT_NAME(RecallProperty.FieldName.PRODUCT_NAME),
        TRADEMARK(RecallProperty.FieldName.TRADEMARK),
        MODEL(RecallProperty.FieldName.MODEL),
        SERIAL_NUMBER(RecallProperty.FieldName.SERIAL_NUMBER),
        TYPE(RecallProperty.FieldName.TYPE),
        COMPANY(RecallProperty.FieldName.COMPANY),
        DATE_OF_ISSUE(RecallProperty.FieldName.DATE_OF_ISSUE),
        DIMENSION_TYPE(RecallProperty.FieldName.DIMENSION_TYPE);

        private final String fieldName;

        Field(String name) {
            this.fieldName = name;
        }

        @Override
        public String toString() {
            return this.fieldName;
        }
    }



    /**
     * enum Direction
     */
    public enum Direction {
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

    /**
     * enum Visibility
     */
    public enum Visibility {
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

    /**
     * enum SortOrder
     */
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

    /**
     * enum Pageable
     */
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

    /**
     * C'tor
     */
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

    public RecallAPIConfig setPageableSortOrders(Map<Field, Direction> orders) {
        JSONObject jsonPageable = getPageableJSONObject();
        JSONArray jsonOrders = new JSONArray();

        for (Map.Entry<Field, Direction> order : orders.entrySet()) {
            JSONObject jsonOrder = new JSONObject();
            jsonOrder.put(SortOrder.PROPERTY.toString(), order.getKey().toString());
            jsonOrder.put(SortOrder.DIRECTION.toString(), new Integer(order.getValue().toInt()));

            jsonOrders.add(jsonOrder);
        }

        jsonPageable.put(Pageable.SORT_ORDERS.toString(), jsonOrders);

        return this;
    }

    public RecallAPIConfig setFieldDistinct(Field field) {
        this.put(PARAM_DISTINCT, field.toString());

        return this;
    }

    public RecallAPIConfig setFieldVisibility(Set<Field> fields, Visibility visibility) {
        Iterator<Field> iter = fields.iterator();
        JSONObject jsonVisibility = new JSONObject();
        Integer intVisibility = new Integer(visibility.toInt());

        while (iter.hasNext()) {
            Field field = iter.next();
            jsonVisibility.put(field.toString(), intVisibility);
        }

        this.put(PARAM_FIELD_VISIBILITY, jsonVisibility);

        return this;
    }

    public RecallAPIConfig setQuery(Condition condition) {
        put(PARAM_SEARCH, condition.toJSONObject());

        return this;
    }
}
