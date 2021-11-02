package com.epam.task03.builder;

import com.epam.task03.exception.DeviceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DevicesSaxBuilderTest {
    private DevicesSaxBuilder saxBuilder;

    private final String PATH_TO_XML_FILE = "./src/test/resources/testDevices.xml";

    private final int QUANTITY_OF_ENTITY = 4;

    @Before
    public void init() {
        saxBuilder = new DevicesSaxBuilder();
    }
    @Test
    public void testBuildSetDevices() throws DeviceException {
        saxBuilder.buildSetDevices(PATH_TO_XML_FILE);
        Assert.assertEquals(saxBuilder.getDevices().size(), QUANTITY_OF_ENTITY);
    }
}
