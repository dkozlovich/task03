package com.epam.task03.exception;

public class DeviceException extends Throwable {
    public DeviceException() {
        super();
    }

    public DeviceException(String message) {
        super(message);
    }

    public DeviceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceException(Throwable cause) {
        super(cause);
    }
}
