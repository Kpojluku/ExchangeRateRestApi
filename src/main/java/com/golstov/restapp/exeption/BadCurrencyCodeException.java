package com.golstov.restapp.exeption;

public class BadCurrencyCodeException extends RuntimeException {

    public BadCurrencyCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadCurrencyCodeException(String message) {
        super(message);
    }
}
