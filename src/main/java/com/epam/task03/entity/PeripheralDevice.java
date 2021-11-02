package com.epam.task03.entity;

import java.time.YearMonth;

public class PeripheralDevice extends Device{
    private PeripheralDeviceType deviceType;
    private PeripheralDevicePort devicePort;

    public PeripheralDevice() {
    }

    public PeripheralDevice(String id, String name, DeviceOrigin origin, YearMonth launchTime, int price,
                            int powerConsumption, boolean cooling, boolean critical, PeripheralDeviceType deviceType, PeripheralDevicePort devicePort) {
        super(id, name, origin, launchTime, price, powerConsumption, cooling, critical);
        this.deviceType = deviceType;
        this.devicePort = devicePort;
    }

    public PeripheralDeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(PeripheralDeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public PeripheralDevicePort getDevicePort() {
        return devicePort;
    }

    public void setDevicePort(PeripheralDevicePort devicePort) {
        this.devicePort = devicePort;
    }
}
