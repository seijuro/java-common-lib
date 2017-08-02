package com.github.seijuro.common.scrap.publicdata.nps;

import java.util.HashMap;
import java.util.Map;

public class BusinessPlaceInfoPropertyUtils {
    public static class Item {
        static final Map<String, Integer> itemMap;

        static {
            itemMap = new HashMap<>();

            itemMap.put(BusinessPlaceInfoProperty.Item.CREATED_YM, BusinessPlaceInfoProperty.ItemCode.IC_CREATED_YM);
            itemMap.put(BusinessPlaceInfoProperty.Item.ID , BusinessPlaceInfoProperty.ItemCode.IC_ID);
            itemMap.put(BusinessPlaceInfoProperty.Item.BUSINESSPLACE_NAME, BusinessPlaceInfoProperty.ItemCode.IC_BUSINESSPLACE_NAME);
            itemMap.put(BusinessPlaceInfoProperty.Item.REGISTRATION_NUMBER , BusinessPlaceInfoProperty.ItemCode.IC_REGISTRATION_NUMBER);
            itemMap.put(BusinessPlaceInfoProperty.Item.ADDRESS_STREET, BusinessPlaceInfoProperty.ItemCode.IC_ADDRESS_STREET);
            itemMap.put(BusinessPlaceInfoProperty.Item.STATUS_CODE, BusinessPlaceInfoProperty.ItemCode.IC_STATUS_CODE);
            itemMap.put(BusinessPlaceInfoProperty.Item.DIVISION_CODE, BusinessPlaceInfoProperty.ItemCode.IC_DIVISION_CODE);
            itemMap.put(BusinessPlaceInfoProperty.Item.ADDRESS_DG, BusinessPlaceInfoProperty.ItemCode.IC_ADDRESS_DG);
            itemMap.put(BusinessPlaceInfoProperty.Item.ADDRESS_SGG, BusinessPlaceInfoProperty.ItemCode.IC_ADDRESS_SGG);
            itemMap.put(BusinessPlaceInfoProperty.Item.ADDRESS_EMD, BusinessPlaceInfoProperty.ItemCode.IC_ADDRESS_EMD);

            itemMap.put(BusinessPlaceInfoProperty.Item.Detail.BUSINESSTYPE_NAME, BusinessPlaceInfoProperty.ItemCode.Detail.IC_BUSINESSTYPE_NAME);
            itemMap.put(BusinessPlaceInfoProperty.Item.Detail.BUSINESSTYPE_CODE, BusinessPlaceInfoProperty.ItemCode.Detail.IC_BUSINESSTYPE_CODE);
            itemMap.put(BusinessPlaceInfoProperty.Item.Detail.REGISTRATION_DATE, BusinessPlaceInfoProperty.ItemCode.Detail.IC_REGISTRATION_DATE);
            itemMap.put(BusinessPlaceInfoProperty.Item.Detail.WITHDRAWAL_DATE, BusinessPlaceInfoProperty.ItemCode.Detail.IC_WITHDRAWAL_DATE);
            itemMap.put(BusinessPlaceInfoProperty.Item.Detail.SUBSCRIBER_NUMBER, BusinessPlaceInfoProperty.ItemCode.Detail.IC_SUBSCRIBER_NUMBER);
            itemMap.put(BusinessPlaceInfoProperty.Item.Detail.NOTIFIED_AMOUNT_OF_THIS_MONTH, BusinessPlaceInfoProperty.ItemCode.Detail.IC_NOTIFIED_AMOUNT_OF_THIS_MONTH);
        }

        public static boolean contains(String key) {
            return itemMap.containsKey(key);
        }

        public static int getCode(String key, int defaultValue) {
            Integer val = itemMap.get(key);

            if (val instanceof Integer) {
                return val;
            }

            return defaultValue;
        }
    }
}
