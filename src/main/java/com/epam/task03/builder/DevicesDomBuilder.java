package com.epam.task03.builder;

import com.epam.task03.entity.*;
import com.epam.task03.exception.DeviceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

public class DevicesDomBuilder extends AbstractDeviceBuilder {

    Set<Device> devices = new HashSet<>();

    @Override
    public Set<Device> buildSetDevices(String path) throws DeviceException {
        File file = new File(path);
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            doc = dbf.newDocumentBuilder().parse(file);
            doc.getDocumentElement().normalize();
            for (DeviceType value : DeviceType.values()) {

                NodeList list = doc.getElementsByTagName(value.toString());
                if (value.equals(DeviceType.PERIPHERAL)) {
                    for (int i = 0; i < list.getLength(); i++) {
                        Element eElement = (Element) list.item(i);
                        String id = eElement.getAttribute("id");
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        DeviceOrigin origin = DeviceOrigin.valueOf(eElement.getElementsByTagName("origin")
                                .item(0).getTextContent().toUpperCase());
                        YearMonth launchTime = YearMonth.parse(eElement.getElementsByTagName("launch-time")
                                .item(0).getTextContent());
                        int price = Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent());
                        int powerConsumption = Integer.parseInt(eElement.getElementsByTagName("power-consumption").item(0).getTextContent());
                        boolean cooling = Boolean.parseBoolean(eElement.getElementsByTagName("cooling").item(0).getTextContent());
                        boolean critical = Boolean.parseBoolean(eElement.getElementsByTagName("critical").item(0).getTextContent());
                        PeripheralDeviceType deviceType = (PeripheralDeviceType) PeripheralDeviceType.valueOf(eElement
                                .getElementsByTagName("peripheral-device-type").item(0).getTextContent().toUpperCase());
                        PeripheralDevicePort devicePort = (PeripheralDevicePort) PeripheralDevicePort.valueOf(eElement
                                .getElementsByTagName("peripheral-device-port").item(0).getTextContent().toUpperCase());
                        devices.add(new PeripheralDevice(id, name, origin, launchTime, price, powerConsumption, cooling, critical, deviceType, devicePort));
                    }
                }
                if (value.equals(DeviceType.INTEGRAL)) {
                    for (int i = 0; i < list.getLength(); i++) {
                        Element eElement = (Element) list.item(i);
                        String id = eElement.getAttribute("id");
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        DeviceOrigin origin = DeviceOrigin.valueOf(eElement.getElementsByTagName("origin")
                                .item(0).getTextContent().toUpperCase());
                        YearMonth launchTime = YearMonth.parse(eElement.getElementsByTagName("launch-time")
                                .item(0).getTextContent());
                        int price = Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent());
                        int powerConsumption = Integer.parseInt(eElement.getElementsByTagName("power-consumption").item(0).getTextContent());
                        boolean cooling = Boolean.parseBoolean(eElement.getElementsByTagName("cooling").item(0).getTextContent());
                        boolean critical = Boolean.parseBoolean(eElement.getElementsByTagName("critical").item(0).getTextContent());
                        IntegralDeviceType deviceType = (IntegralDeviceType) IntegralDeviceType.valueOf(eElement
                                .getElementsByTagName("integral-device-type").item(0).getTextContent());
                        devices.add(new IntegralDevice(id, name, origin, launchTime, price, powerConsumption, cooling, critical, deviceType));
                    }
                }
            }
        } catch (Exception e) {
            throw new DeviceException(e);
        }
        return null;
    }
}
