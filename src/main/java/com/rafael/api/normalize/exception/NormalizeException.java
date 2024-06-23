package com.rafael.api.normalize.exception;

import java.io.Serial;

public class NormalizeException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NormalizeException(String message) {
        super(message);
    }
}
