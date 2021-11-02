package com.epam.task03.entity;

import java.time.YearMonth;

public class IntegralDevice extends Device{
    private IntegralDeviceType deviceType;

    public IntegralDevice() {
    }

    public IntegralDevice(String id, String name, DeviceOrigin origin, YearMonth launchTime, int price,
                          int powerConsumption, boolean cooling, boolean critical, IntegralDeviceType deviceType) {
        super(id, name, origin, launchTime, price, powerConsumption, cooling, critical);
        this.deviceType = deviceType;
    }

    public IntegralDeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(IntegralDeviceType deviceType) {
        this.deviceType = deviceType;
    }
}
