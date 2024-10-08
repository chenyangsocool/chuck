package com.example.truck.common.type;

import com.example.truck.common.type.common.BaseType;

/**
 * show type
 */
public class ShowType extends BaseType {

    private volatile static ShowType type;

    private ShowType() {
    }

    public ShowType(String value, String label) {
        super(value, label);
    }

    public static ShowType getAllElement() {
        synchronized (ShowType.class) {
            if (type == null) {
                type = new ShowType();
            }
        }
        return type;
    }

    public static String getEnumName() {
        return getAllElement().getClass().getSimpleName();
    }

    public static final ShowType ERROR_MESSAGE = new ShowType("error_message", "error message");
    public static final ShowType NOTIFICATION = new ShowType("notification", "notification");
    public static final ShowType SILENT = new ShowType("silent", "silent");
    public static final ShowType WARN_MESSAGE = new ShowType("warn_message", "warn message");
}
