package com.vladnickgofj.hotel.service.exception;

import static com.vladnickgofj.hotel.HttpStatusCodes.NOT_CORRECT_EMAIL;

public class InvalidEmailException extends RuntimeException {
    private static final Integer STATUS_CODE = NOT_CORRECT_EMAIL;

    public InvalidEmailException(String message) {
        super(message);
    }

    public static Integer getCode() {
        return STATUS_CODE;
    }

}
