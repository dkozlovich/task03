package com.epam.task03.builder;

import com.epam.task03.builder.type.BuilderType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CancellationException;

public class DevicesBuilderFactory {
    private static Logger logger = LogManager.getLogger();

    public AbstractDeviceBuilder createDeviceBuilder(String typeBuilder) {
        BuilderType builderType = BuilderType.valueOf(typeBuilder.toUpperCase());
        switch (builderType) {
            case DOM:
                logger.info("DOM was chose");
                return new DevicesDomBuilder();
            case SAX:
                logger.info("SAX was chose");
                return new DevicesSaxBuilder();
            case STAX:
                logger.info("STAX was chose");
                return new DevicesStaxBuilder();
            default:
                throw new CancellationException("There is no " + typeBuilder + " builder.");
        }

    }
}
