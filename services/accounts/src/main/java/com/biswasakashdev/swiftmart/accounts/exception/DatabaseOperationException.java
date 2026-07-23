package com.biswasakashdev.swiftmart.accounts.exception;


public class DatabaseOperationException extends RuntimeException{

    public DatabaseOperationException(String message) {
        super(message);
    }
}
