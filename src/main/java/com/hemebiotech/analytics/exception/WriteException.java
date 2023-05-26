package com.hemebiotech.analytics.exception;

/**
 * Custom Exception thrown if writing problem
 */
public class WriteException extends RuntimeException {

    public WriteException(String message, Throwable cause) {
        super(message, cause);
    }

}
