package com.vladnickgofj.hotel.dao.exception.registerPageExceptions;

import static com.vladnickgofj.hotel.HttpStatusCodes.NOT_CORRECT_CONFIRMATION_PASSWORD;

public class RegisterPageInvalidConfirmationPassword extends RuntimeException {
    private static final Integer STATUS_CODE = NOT_CORRECT_CONFIRMATION_PASSWORD;
    public RegisterPageInvalidConfirmationPassword(String message) {
        super(message);
    }
    public static Integer getCode() {
        return STATUS_CODE;
    }
}
