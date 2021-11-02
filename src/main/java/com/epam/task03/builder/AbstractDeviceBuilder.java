package com.epam.task03.builder;

import com.epam.task03.entity.Device;
import com.epam.task03.exception.DeviceException;

import java.util.Set;

public abstract class AbstractDeviceBuilder {
    protected Set<Device> devices;
    abstract public void buildSetDevices(String path) throws DeviceException;

    public Set<Device> getDevices() {
        return devices;
    }
}
