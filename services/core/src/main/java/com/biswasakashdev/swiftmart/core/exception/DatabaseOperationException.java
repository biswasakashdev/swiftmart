package com.biswasakashdev.swiftmart.core.exception;


public class DatabaseOperationException extends RuntimeException{

    public DatabaseOperationException(String message) {
        super(message);
    }
}
