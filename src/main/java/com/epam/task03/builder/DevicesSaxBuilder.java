package com.epam.task03.builder;

import com.epam.task03.entity.Device;
import com.epam.task03.exception.DeviceException;
import com.epam.task03.handler.DevicesHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class DevicesSaxBuilder extends AbstractDeviceBuilder{

    Set<Device> devices = new HashSet<>();

    private DevicesHandler devicesHandler;

    public DevicesSaxBuilder() {
        devicesHandler = new DevicesHandler();
    }

    public Set<Device> getDevices() {
        super.devices = devicesHandler.getDevices();
        devices = devicesHandler.getDevices();
        return devices;
    }

    @Override
    public Set<Device> buildSetDevices(String path) throws DeviceException {
        File file = new File(path);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        DevicesHandler devicesHandler = new DevicesHandler();
        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (Exception e) {
            throw new DeviceException(e);
        }
        try {
            saxParser.parse(file, devicesHandler);
        } catch (Exception e) {
            throw new DeviceException(e);
        }
        devices = devicesHandler.getDevices();
        return devices;
    }


}
