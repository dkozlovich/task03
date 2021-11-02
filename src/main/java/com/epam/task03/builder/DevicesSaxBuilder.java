package com.epam.task03.builder;

import com.epam.task03.entity.Device;
import com.epam.task03.exception.DeviceException;
import com.epam.task03.handler.DevicesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class DevicesSaxBuilder extends AbstractDeviceBuilder{

    private static final Logger logger = LogManager.getLogger();

    private Set<Device> devices = new HashSet<>();

    @Override
    public Set<Device> getDevices() {
        return devices;
    }

    @Override
    public void buildSetDevices(String path) throws DeviceException {
        File file = new File(path);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        DevicesHandler devicesHandler = new DevicesHandler();
        logger.info("Start parsing with SAX Parser");
        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (Exception e) {
            throw new DeviceException(e);
        }
        try {
            saxParser.parse(file, devicesHandler);
            logger.info("Parsing successfully done");
        } catch (Exception e) {
            logger.info("Error during parsing: " + e.getMessage());
            throw new DeviceException(e);
        }
        devices = devicesHandler.getDevices();
    }
}
