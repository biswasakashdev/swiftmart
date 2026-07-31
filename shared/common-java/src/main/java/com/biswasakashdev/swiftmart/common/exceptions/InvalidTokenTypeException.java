package com.biswasakashdev.swiftmart.common.exceptions;

public class InvalidTokenTypeException extends RuntimeException{
    public InvalidTokenTypeException(String message){
        super(message);
    }
}
