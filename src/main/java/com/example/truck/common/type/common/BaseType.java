package com.example.truck.common.type.common;

import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * base enum or type
 */
@Getter
public class BaseType {

    /**
     * enum value
     */
    private String value;

    /**
     * enum label
     */
    private String label;

    /**
     * child type
     */
    @SuppressWarnings("rawtypes")
    private Class enumClass;

    public BaseType() {
        enumClass = this.getClass();
    }

    /**
     * init
     *
     * @param value enum value
     * @param label enum label
     */
    public BaseType(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static final BaseType NO_MATCH = new BaseType("no_match", "");

    /**
     * check contains
     *
     * @param value enum value
     * @return is contain
     */
    @SneakyThrows
    public Boolean contains(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        if (NO_MATCH.getValue().equals(value)) {
            return false;
        }
        for (Field field : enumClass.getFields()) {
            if (((BaseType) field.get(0)).getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * check not contain
     *
     * @param value enum value
     * @return is not contain
     */
    public Boolean notContains(String value) {
        return !contains(value);
    }
}
