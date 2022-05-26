package com.vladnickgofj.hotel.dao.exception.registerPageExceptions;

public class RegisterPageLastNameErrorException extends RuntimeException {
    public RegisterPageLastNameErrorException(String lastNameErrorMessage) {
        super(lastNameErrorMessage);
    }
}
