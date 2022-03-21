package com.vladnickgofj.hotel.validator;

import com.vladnickgofj.hotel.servlet.dto.UserDto;

import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;

import static com.vladnickgofj.hotel.validator.Patterns.EMAIL_PATTERN;
import static com.vladnickgofj.hotel.validator.Patterns.REGEX_FOR_EMAIL;
import static com.vladnickgofj.hotel.validator.ValidatorErrorMessage.EMAIL_ERROR_MESSAGE;
import static com.vladnickgofj.hotel.validator.ValidatorErrorMessage.USER_IS_NULL_MESSAGE;
import static org.apache.commons.lang.StringUtils.isBlank;

public class UserValidator implements Validator<UserDto> {

    @Override
    public void validate(UserDto entity) {
        if (entity == null) {
            throw new IllegalArgumentException(USER_IS_NULL_MESSAGE);
        }
        validateByParam(UserDto::getEmail, EMAIL_PATTERN, EMAIL_ERROR_MESSAGE, entity);
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
