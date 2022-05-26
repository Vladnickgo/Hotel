package com.vladnickgofj.hotel.dao.exception.registerPageExceptions;

public class RegisterPageConfirmationPasswordErrorException extends RuntimeException {
    public RegisterPageConfirmationPasswordErrorException(String confirmationPasswordErrorMessage) {
        super(confirmationPasswordErrorMessage);
    }
}
