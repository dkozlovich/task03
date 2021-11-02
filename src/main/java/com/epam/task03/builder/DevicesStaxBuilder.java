package com.epam.task03.builder;

import com.epam.task03.entity.*;
import com.epam.task03.exception.DeviceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

public class DevicesStaxBuilder extends AbstractDeviceBuilder {

    private static final Logger logger = LogManager.getLogger();

    private Set<Device> devices = new HashSet<>();

    private IntegralDevice currentIntegralDevice;

    private PeripheralDevice currentPeripheralDevice;

    @Override
    public Set<Device> getDevices() {
        return devices;
    }

    @Override
    public void buildSetDevices(String path) throws DeviceException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        logger.info("Start parsing with StAX Parser");
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("integral-device")) {
                        currentIntegralDevice = new IntegralDevice();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            currentIntegralDevice.setId(idAttr.getValue());
                        }
                    } else if (startElement.getName().getLocalPart().equals("peripheral-device")) {
                        currentPeripheralDevice = new PeripheralDevice();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            currentPeripheralDevice.setId(idAttr.getValue());
                        }
                    } else if (currentIntegralDevice != null) {
                        switch (startElement.getName().getLocalPart()) {
                            case "name":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentIntegralDevice.setName(xmlEvent.asCharacters().getData());
                                break;
                            case "origin":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentIntegralDevice.setOrigin(DeviceOrigin.valueOf(xmlEvent.asCharacters().getData().toUpperCase()));
                                break;
                            case "launch-time":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentIntegralDevice.setLaunchTime(YearMonth.parse(xmlEvent.asCharacters().getData()));
                                break;
                            case "price":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentIntegralDevice.setPrice(Integer.parseInt(xmlEvent.asCharacters().getData()));
                                break;
                            case "power-consumption":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentIntegralDevice.setPowerConsumption(Integer.parseInt(xmlEvent.asCharacters().getData()));
                                break;
                            case "cooling":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentIntegralDevice.setCooling(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                                break;
                            case "critical":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentIntegralDevice.setCritical(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                                break;
                            case "integral-device-type":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentIntegralDevice.setDeviceType(IntegralDeviceType.valueOf(xmlEvent.asCharacters().getData().toUpperCase()));
                                break;
                        }
                    }

                    if (currentPeripheralDevice != null) {
                        switch (startElement.getName().getLocalPart()) {
                            case "name":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentPeripheralDevice.setName(xmlEvent.asCharacters().getData());
                                break;
                            case "origin":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentPeripheralDevice.setOrigin(DeviceOrigin.valueOf(xmlEvent.asCharacters().getData().toUpperCase()));
                                break;
                            case "launch-time":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentPeripheralDevice.setLaunchTime(YearMonth.parse(xmlEvent.asCharacters().getData()));
                                break;
                            case "price":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentPeripheralDevice.setPrice(Integer.parseInt(xmlEvent.asCharacters().getData()));
                                break;
                            case "power-consumption":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentPeripheralDevice.setPowerConsumption(Integer.parseInt(xmlEvent.asCharacters().getData()));
                                break;
                            case "cooling":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentPeripheralDevice.setCooling(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                                break;
                            case "critical":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentPeripheralDevice.setCritical(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                                break;
                            case "peripheral-device-type":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentPeripheralDevice.setDeviceType(PeripheralDeviceType.valueOf(xmlEvent.asCharacters().getData().toUpperCase()));
                                break;
                            case "peripheral-device-port":
                                xmlEvent = xmlEventReader.nextEvent();
                                currentPeripheralDevice.setDevicePort(PeripheralDevicePort.valueOf(xmlEvent.asCharacters().getData().toUpperCase()));
                                break;
                        }
                    }
                }
                if (xmlEvent.isEndElement() && currentIntegralDevice != null) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("integral-device")) {
                        devices.add(currentIntegralDevice);
                        currentIntegralDevice = null;
                    }
                }
                if (xmlEvent.isEndElement() && currentPeripheralDevice != null) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("peripheral-device")) {
                        devices.add(currentPeripheralDevice);
                        currentPeripheralDevice = null;
                    }
                }
            }
            logger.info("Parsing successfully done");
        } catch (Exception e) {
            logger.info("Error during parsing: " + e.getMessage());
            throw new DeviceException(e);
        }
    }
}
