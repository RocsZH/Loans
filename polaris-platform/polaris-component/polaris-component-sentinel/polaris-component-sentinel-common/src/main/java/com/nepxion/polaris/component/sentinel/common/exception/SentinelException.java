package com.nepxion.polaris.component.sentinel.common.exception;

public class SentinelException extends RuntimeException {
    private static final long serialVersionUID = 8444398274695276795L;

    public SentinelException() {
        super();
    }

    public SentinelException(String message) {
        super(message);
    }

    public SentinelException(String message, Throwable cause) {
        super(message, cause);
    }

    public SentinelException(Throwable cause) {
        super(cause);
    }
}