package com.vladnickgofj.hotel.validator;

import com.vladnickgofj.hotel.controller.dto.UserDto;
import com.vladnickgofj.hotel.dao.exception.loginPageExceptions.LoginPageEmailErrorException;
import com.vladnickgofj.hotel.dao.exception.registerPageExceptions.RegisterPageConfirmationPasswordErrorException;
import com.vladnickgofj.hotel.dao.exception.registerPageExceptions.RegisterPageFirstNameErrorException;
import com.vladnickgofj.hotel.dao.exception.registerPageExceptions.RegisterPageLastNameErrorException;
import com.vladnickgofj.hotel.dao.exception.registerPageExceptions.RegisterPagePasswordErrorException;
import com.vladnickgofj.hotel.dao.exception.registerPageExceptions.RegisterPageEmailErrorException;

import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;

import static com.vladnickgofj.hotel.validator.Patterns.*;
import static com.vladnickgofj.hotel.validator.ValidatorErrorMessage.*;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class UserValidator implements Validator<UserDto> {

    @Override
    public void validate(UserDto entity) throws RegisterPageEmailErrorException {
        if (entity == null) {
            throw new IllegalArgumentException(USER_IS_NULL_MESSAGE);
        }
        validateByParam(UserDto::getEmail, EMAIL_PATTERN, /*EMAIL_ERROR_MESSAGE, */entity, new RegisterPageEmailErrorException(EMAIL_ERROR_MESSAGE));
//        validateByParam(UserDto::getFirstName, FIRST_NAME_PATTERN, FIRST_NAME_ERROR_MESSAGE, entity);
//        validateByParam(UserDto::getLastName, LAST_NAME_PATTERN, LAST_NAME_ERROR_MESSAGE, entity);
//        validateByParam(UserDto::getPassword, PASSWORD_PATTERN, PASSWORD_ERROR_MESSAGE, entity);
//        validateByParam(UserDto::getConfirmationPassword, PASSWORD_PATTERN, CONFIRMATION_PASSWORD_ERROR_MESSAGE, entity);


        validateByParam(UserDto::getFirstName, FIRST_NAME_PATTERN, entity, new RegisterPageFirstNameErrorException(FIRST_NAME_ERROR_MESSAGE));
        validateByParam(UserDto::getLastName, LAST_NAME_PATTERN, entity, new RegisterPageLastNameErrorException(FIRST_NAME_ERROR_MESSAGE));
        validateByParam(UserDto::getPassword, PASSWORD_PATTERN, entity, new RegisterPagePasswordErrorException(PASSWORD_ERROR_MESSAGE));
        validateByParam(UserDto::getConfirmationPassword, PASSWORD_PATTERN, entity, new RegisterPageConfirmationPasswordErrorException(CONFIRMATION_PASSWORD_ERROR_MESSAGE));


    }

    public void validateEmail(String email) {
        if (isBlank(email) || !email.matches(REGEX_FOR_EMAIL)) {
            throw new LoginPageEmailErrorException(EMAIL_ERROR_MESSAGE);
        }
    }

    private void validateByParam(Function<UserDto, String> param, Pattern pattern, /*String errorMessage, */UserDto user, RuntimeException exception) {
        Optional.ofNullable(param.apply(user))
                .filter(x -> pattern.matcher(x).matches())
                .orElseThrow(() -> exception);
    }
}
