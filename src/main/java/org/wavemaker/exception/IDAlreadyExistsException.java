package org.wavemaker.exception;

public class IDAlreadyExistsException extends Throwable {
    public IDAlreadyExistsException(String errorMessage){
        System.out.println(errorMessage);
    }
}
