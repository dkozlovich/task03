package com.epam.task03.builder;

import com.epam.task03.entity.Device;
import com.epam.task03.entity.DeviceOrigin;
import com.epam.task03.entity.IntegralDevice;
import com.epam.task03.entity.IntegralDeviceType;
import com.epam.task03.exception.DeviceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.YearMonth;
import java.util.Set;

public class DevicesSaxBuilderTest {
    private DevicesSaxBuilder saxBuilder;

    private final String PATH_TO_XML_FILE = "./src/test/resources/testDevices.xml";

    private final int QUANTITY_OF_ENTITY = 16;

    @Before
    public void init() {
        saxBuilder = new DevicesSaxBuilder();
    }
    @Test
    public void testBuildSetDevices() throws DeviceException {
        saxBuilder.buildSetDevices(PATH_TO_XML_FILE);
        Assert.assertEquals(QUANTITY_OF_ENTITY, saxBuilder.getDevices().size());
    }

    @Test
    public void testBuildSetDevices2() throws DeviceException {
        saxBuilder.buildSetDevices(PATH_TO_XML_FILE);
        Set<Device> result = saxBuilder.getDevices();
        IntegralDevice expected = new IntegralDevice();
        expected.setId("11");
        expected.setName("Motherboard Gigabyte B450M");
        expected.setOrigin(DeviceOrigin.USA);
        expected.setLaunchTime(YearMonth.parse("2020-09"));
        expected.setPrice(50);
        expected.setPowerConsumption(15);
        expected.setCooling(false);
        expected.setCritical(true);
        expected.setDeviceType(IntegralDeviceType.MOTHERBOARD);
        Assert.assertTrue(result.contains(expected));
    }


}
