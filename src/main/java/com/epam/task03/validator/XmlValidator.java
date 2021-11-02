package com.epam.task03.validator;

import com.epam.task03.builder.DeviceErrorHandler;
import com.epam.task03.exception.DeviceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    private static final Logger logger = LogManager.getLogger();

    public static boolean isValidXML(String xmlFilePath, String schemaPath) throws DeviceException {
        String language = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaPath);

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFilePath);
            validator.setErrorHandler(new DeviceErrorHandler());
            validator.validate(source);
        } catch (SAXException exception) {
            logger.error("File is not valid: " + exception.getMessage());
            return false;
        } catch (IOException exception) {
            logger.error("I/O error: " + exception.getMessage());
            throw new DeviceException(exception);
        }
        return true;
    }
}
