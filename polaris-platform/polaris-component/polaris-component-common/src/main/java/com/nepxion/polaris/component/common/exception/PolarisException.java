package com.nepxion.polaris.component.common.exception;

public class PolarisException extends RuntimeException {
    private static final long serialVersionUID = 8444398274695276795L;

    public PolarisException() {
        super();
    }

    public PolarisException(String message) {
        super(message);
    }

    public PolarisException(String message, Throwable cause) {
        super(message, cause);
    }

    public PolarisException(Throwable cause) {
        super(cause);
    }
}