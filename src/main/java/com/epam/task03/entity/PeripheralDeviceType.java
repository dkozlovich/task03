package com.epam.task03.entity;

public enum PeripheralDeviceType {
    MULTIMEDIA(),
    INPUT_OUTPUT();

    private String value;

    PeripheralDeviceType() {
        this.value = this.toString();
    }

    public String getValue() {
        return value;
    }
}
