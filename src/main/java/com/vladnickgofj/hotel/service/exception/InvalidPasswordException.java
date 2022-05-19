package com.vladnickgofj.hotel.service.exception;

import static com.vladnickgofj.hotel.HttpStatusCodes.NOT_CORRECT_PASSWORD;

public class InvalidPasswordException extends RuntimeException {
    private static final Integer STATUS_CODE = NOT_CORRECT_PASSWORD;

    public InvalidPasswordException(String message) {
        super(message);
    }

    public static Integer getCode() {
        return STATUS_CODE;
    }
}
