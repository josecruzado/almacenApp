package com.practica.josetec.domain.exceptions;

public class InvalidSaleException extends Exception {

    public InvalidSaleException() {
        super();
    }

    public InvalidSaleException(String message) {
        super(message);
    }

    public InvalidSaleException(Throwable cause) {
        super(cause);
    }

    public InvalidSaleException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSaleException(String message, Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

