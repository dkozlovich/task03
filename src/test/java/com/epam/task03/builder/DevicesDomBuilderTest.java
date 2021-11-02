package com.epam.task03.builder;

import com.epam.task03.exception.DeviceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DevicesDomBuilderTest {

    private DevicesDomBuilder domBuilder;

    private final String PATH_TO_XML_FILE = "./src/test/resources/testDevices.xml";

    private final int QUANTITY_OF_ENTITY = 5;

    @Before
    public void init() {
        domBuilder = new DevicesDomBuilder();
    }

    @Test
    public void testBuildSetDevices() throws DeviceException {
        domBuilder.buildSetDevices(PATH_TO_XML_FILE);
        Assert.assertEquals(domBuilder.getDevices().size(), QUANTITY_OF_ENTITY);
    }
}
