package com.vladnickgofj.hotel.validator;

import com.vladnickgofj.hotel.servlet.dto.UserDto;

import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;

import static com.vladnickgofj.hotel.validator.Patterns.*;
import static com.vladnickgofj.hotel.validator.ValidatorErrorMessage.*;
import static org.apache.commons.lang.StringUtils.isBlank;

public class UserValidator implements Validator<UserDto> {

    @Override
    public void validate(UserDto entity) {
        if (entity == null) {
            throw new IllegalArgumentException(USER_IS_NULL_MESSAGE);
        }
        validateByParam(UserDto::getEmail, EMAIL_PATTERN, EMAIL_ERROR_MESSAGE, entity);
        validateByParam(UserDto::getFirstName, FIRST_NAME_PATTERN, FIRST_NAME_ERROR_MESSAGE, entity);
        validateByParam(UserDto::getLastName, LAST_NAME_PATTERN, LAST_NAME_ERROR_MESSAGE, entity);
        validateByParam(UserDto::getPassword, PASSWORD_PATTERN, PASSWORD_ERROR_MESSAGE, entity);
        validateByParam(UserDto::getConfirmationPassword, PASSWORD_PATTERN, CONFIRMATION_PASSWORD_ERROR_MESSAGE, entity);
    }

    public void validateEmail(String email) {
        if (isBlank(email) || !email.matches(REGEX_FOR_EMAIL)) {
            throw new RuntimeException(EMAIL_ERROR_MESSAGE);
        }
    }

    private void validateByParam(Function<UserDto, String> param, Pattern pattern, String errorMessage, UserDto user) {
        Optional.ofNullable(param.apply(user))
                .filter(x -> pattern.matcher(x).matches())
                .orElseThrow(() -> new RuntimeException(errorMessage));
    }
}
