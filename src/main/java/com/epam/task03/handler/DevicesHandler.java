package com.epam.task03.handler;

import com.epam.task03.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

public class DevicesHandler extends DefaultHandler {

    Set<Device> devices = new HashSet<>();

    IntegralDevice currentIntegralDevice;

    PeripheralDevice currentPeripheralDevice;

    private StringBuilder currentValue = new StringBuilder();

    public Set<Device> getDevices() {
        return devices;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentValue.setLength(0);
        if (qName.equalsIgnoreCase("integral-device")) {
            currentIntegralDevice = new IntegralDevice();
            String id = attributes.getValue("id");
            currentIntegralDevice.setId(id);
        }
        if (qName.equalsIgnoreCase("peripheral-device")) {
            currentPeripheralDevice = new PeripheralDevice();
            String id = attributes.getValue("id");
            currentPeripheralDevice.setId(id);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentIntegralDevice != null) {
            switch (qName) {
                case "name":
                    currentIntegralDevice.setName(currentValue.toString());
                    break;
                case "origin":
                    currentIntegralDevice.setOrigin(DeviceOrigin.valueOf(currentValue.toString().toUpperCase()));
                    break;
                case "launch-time":
                    currentIntegralDevice.setLaunchTime(YearMonth.parse(currentValue.toString()));
                    break;
                case "price":
                    currentIntegralDevice.setPrice(Integer.parseInt(currentValue.toString()));
                    break;
                case "power-consumption":
                    currentIntegralDevice.setPowerConsumption(Integer.parseInt(currentValue.toString()));
                    break;
                case "cooling":
                    currentIntegralDevice.setCooling(Boolean.parseBoolean(currentValue.toString()));
                    break;
                case "critical":
                    currentIntegralDevice.setCritical(Boolean.parseBoolean(currentValue.toString()));
                    break;
                case "integral-device-type":
                    currentIntegralDevice.setDeviceType(IntegralDeviceType.valueOf(currentValue.toString().toUpperCase()));
                    break;
                case "integral-device":
                    devices.add(currentIntegralDevice);
                    currentIntegralDevice = null;
                    break;
            }
        }
        if (currentPeripheralDevice != null) {
            switch (qName) {
                case "name":
                    currentPeripheralDevice.setName(currentValue.toString());
                    break;
                case "origin":
                    currentPeripheralDevice.setOrigin(DeviceOrigin.valueOf(currentValue.toString().toUpperCase()));
                    break;
                case "launch-time":
                    currentPeripheralDevice.setLaunchTime(YearMonth.parse(currentValue.toString()));
                    break;
                case "price":
                    currentPeripheralDevice.setPrice(Integer.parseInt(currentValue.toString()));
                    break;
                case "power-consumption":
                    currentPeripheralDevice.setPowerConsumption(Integer.parseInt(currentValue.toString()));
                    break;
                case "cooling":
                    currentPeripheralDevice.setCooling(Boolean.parseBoolean(currentValue.toString()));
                    break;
                case "critical":
                    currentPeripheralDevice.setCritical(Boolean.parseBoolean(currentValue.toString()));
                    break;
                case "peripheral-device-type":
                    currentPeripheralDevice.setDeviceType(PeripheralDeviceType.valueOf(currentValue.toString().toUpperCase()));
                    break;
                case "peripheral-device-port":
                    currentPeripheralDevice.setDevicePort(PeripheralDevicePort.valueOf(currentValue.toString().toUpperCase()));
                    break;
                case "peripheral-device":
                    devices.add(currentPeripheralDevice);
                    currentPeripheralDevice = null;
                    break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)  {
        currentValue.append(ch, start, length);
    }
}
