package com.epam.task03.entity;

public enum IntegralDeviceType {
    CPU,
    MOTHERBOARD,
    RAM;

    private String value;

    IntegralDeviceType() {
        this.value = this.toString();
    }

    public String getValue() {
        return value;
    }
}
