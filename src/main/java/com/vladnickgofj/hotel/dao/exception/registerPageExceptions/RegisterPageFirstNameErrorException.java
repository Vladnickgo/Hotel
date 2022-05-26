package com.vladnickgofj.hotel.dao.exception.registerPageExceptions;

public class RegisterPageFirstNameErrorException extends RuntimeException {
    public RegisterPageFirstNameErrorException(String firstNameErrorMessage) {
        super(firstNameErrorMessage);
    }
}
