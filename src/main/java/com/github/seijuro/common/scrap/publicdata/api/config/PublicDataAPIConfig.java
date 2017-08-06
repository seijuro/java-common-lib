package com.github.seijuro.common.scrap.publicdata.api.config;

import lombok.AccessLevel;
import lombok.Getter;
import org.json.simple.JSONObject;

import java.util.Properties;

public class PublicDataAPIConfig {
    @Getter(AccessLevel.PUBLIC)
    private Properties properties = new Properties();

    public <T extends ConfigProperty, V extends Number>
    Object setProperty(T property, V value) {
        return getProperties().put(property.getProperty(), value);
    }

    public <T extends ConfigProperty>
    Object setProperty(T property, String value) {
        return getProperties().put(property.getProperty(), value);
    }

    public <T extends  ConfigProperty, V extends ConfigPropertyValue>
    Object setProperty(T property, V value) {
        return getProperties().put(property.getProperty(), value.getValue());
    }

    public <T extends  ConfigProperty, V extends JSONObject>
    Object setProperty(T property, V value) {
        return getProperties().put(property.getProperty(), value.toJSONString());
    }

    public <T1 extends ConfigProperty, T2>
    T2 getProperty(T1 property, Class<T2> Clazz) {
        return Clazz.cast(getProperties().get(property.getProperty()));
    }

    public PublicDataAPIConfig() {
        super();
    }
}
