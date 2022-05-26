package com.vladnickgofj.hotel.dao.exception.registerPageExceptions;

public class RegisterPagePasswordErrorException extends RuntimeException {
    public RegisterPagePasswordErrorException(String passwordErrorMessage) {
        super(passwordErrorMessage);
    }
}
