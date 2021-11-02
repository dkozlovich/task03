package com.epam.task03.entity;

import java.time.YearMonth;

public abstract class Device {

    private String id;
    private String name;
    private DeviceOrigin origin;
    private YearMonth launchTime;
    private int price;
    private int powerConsumption;
    private boolean cooling;
    private boolean critical;

    public Device() {
        id = name = "";
    }

    public Device(String id, String name, DeviceOrigin origin, YearMonth launchTime, int price,
                  int powerConsumption, boolean cooling, boolean critical) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.launchTime = launchTime;
        this.price = price;
        this.powerConsumption = powerConsumption;
        this.cooling = cooling;
        this.critical = critical;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(DeviceOrigin origin) {
        this.origin = origin;
    }

    public YearMonth getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(YearMonth launchTime) {
        this.launchTime = launchTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public boolean isCooling() {
        return cooling;
    }

    public void setCooling(boolean cooling) {
        this.cooling = cooling;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (price != device.price) return false;
        if (powerConsumption != device.powerConsumption) return false;
        if (cooling != device.cooling) return false;
        if (critical != device.critical) return false;
        if (id != null ? !id.equals(device.id) : device.id != null) return false;
        if (name != null ? !name.equals(device.name) : device.name != null) return false;
        if (origin != null ? !origin.equals(device.origin) : device.origin != null) return false;
        return launchTime != null ? launchTime.equals(device.launchTime) : device.launchTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (launchTime != null ? launchTime.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + powerConsumption;
        result = 31 * result + (cooling ? 1 : 0);
        result = 31 * result + (critical ? 1 : 0);
        return result;
    }
}
