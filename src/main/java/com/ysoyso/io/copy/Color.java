package com.ysoyso.io.copy;

import java.io.Serializable;

public class Color implements Serializable {
    public static final Color RED = new Color("#FF0000");
    public static final Color GREEN = new Color("#00FF00");
    public static final Color BLUE = new Color("#0000FF");
    String value;
    private Color(){}
    private Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    protected Object readResolve() {
        if (RED.value.equals(value)) {
            return RED;
        } else if (GREEN.value.equals(value)) {
            return GREEN;
        } else if (BLUE.value.equals(value)) {
            return BLUE;
        }
        return null;
    }
}
