package com.tuana9a.learnjavabasic;

public class CustomException extends Exception {
    public String errorMessage;
    public CustomException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
