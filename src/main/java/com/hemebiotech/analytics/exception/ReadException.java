package com.hemebiotech.analytics.exception;

/**
 * Custom Exception thrown if reading problem
 */
public class ReadException extends RuntimeException {

    public ReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
