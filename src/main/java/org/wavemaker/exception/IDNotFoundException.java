package org.wavemaker.exception;

public class IDNotFoundException extends Exception {
    public IDNotFoundException(String errorMessage){
        System.out.println(errorMessage);
    }
}
