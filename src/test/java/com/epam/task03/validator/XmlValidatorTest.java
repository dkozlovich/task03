package com.epam.task03.validator;

import com.epam.task03.exception.DeviceException;
import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {

    private final String PATH_TO_XML_FILE = "./src/test/resources/testDevices.xml";

    private final String PATH_TO_SCHEMA_FILE = "./src/test/resources/testSchema.xsd";

    @Test
    public void testValidateXML() throws DeviceException {
        XmlValidator validator = new XmlValidator();
        boolean actual = validator.isValidXML(PATH_TO_XML_FILE, PATH_TO_SCHEMA_FILE);
        Assert.assertTrue(actual);
    }
}
