package com.vladnickgofj.hotel.validator;

import java.util.regex.Pattern;

public class Patterns {
    public static final String REGEX_FOR_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    public static final Pattern EMAIL_PATTERN = Pattern.compile(REGEX_FOR_EMAIL);
}
