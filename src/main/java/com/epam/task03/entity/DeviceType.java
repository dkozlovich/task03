package com.epam.task03.entity;

public enum DeviceType {

    PERIPHERAL("peripheral-device"),
    INTEGRAL("integral-device");

    private final String value;

    DeviceType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
