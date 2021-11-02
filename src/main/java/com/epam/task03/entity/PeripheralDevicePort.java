package com.epam.task03.entity;

public enum PeripheralDevicePort {
    COM(),
    USB(),
    LPT();
    private String value;

    PeripheralDevicePort() {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
