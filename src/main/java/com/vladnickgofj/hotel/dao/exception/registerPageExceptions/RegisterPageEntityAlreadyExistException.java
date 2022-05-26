package com.vladnickgofj.hotel.dao.exception.registerPageExceptions;

public class RegisterPageEntityAlreadyExistException extends RuntimeException {

    public RegisterPageEntityAlreadyExistException(String msg) {
        super(msg);
    }

}
