package com.vladnickgofj.hotel.service.impl;

import com.vladnickgofj.hotel.connection.HikariConnectionPool;
import com.vladnickgofj.hotel.dao.UserDao;
import com.vladnickgofj.hotel.dao.entity.User;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.service.exception.EntityAlreadyExistException;
import com.vladnickgofj.hotel.service.mapper.Mapper;
import com.vladnickgofj.hotel.controller.dto.UserDto;
import com.vladnickgofj.hotel.service.mapper.UserMapper;
import com.vladnickgofj.hotel.validator.UserValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.Objects;

import static com.vladnickgofj.hotel.validator.ValidatorErrorMessage.*;

public class UserServiceImpl implements UserService {

    private final HikariConnectionPool hikariConnectionPool;
    private final UserDao userRepository;
    private final Mapper<UserDto, User> mapper;
    private final UserValidator userValidator;
    private HttpServletRequest request;
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    public UserServiceImpl(HikariConnectionPool hikariConnectionPool, UserDao userRepository, Mapper<UserDto, User> mapper, UserValidator userValidator) {
        this.hikariConnectionPool = hikariConnectionPool;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.userValidator = userValidator;
    }

    @Override
    public UserDto findByEmail(String email) {
        userValidator.validateEmail(email);
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new IllegalArgumentException(USER_NOT_FOUND));
        return mapper.mapEntityToDto(user);
    }

    @Override
    public void save(UserDto userDto) {

        userValidator.validateEmail(userDto.getEmail());
        userValidator.validate(userDto);
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            LOGGER.info(USER_ALREADY_EXIST_ERROR_MESSAGE);
            throw new EntityAlreadyExistException(USER_ALREADY_EXIST_ERROR_MESSAGE);
        }
        String password = userDto.getPassword();
        String confirmationPassword = userDto.getConfirmationPassword();
        if (!Objects.equals(password, confirmationPassword) || Objects.equals(password, "")) {
            LOGGER.info(CONFIRMATION_PASSWORD_ERROR_MESSAGE);
            throw new IllegalArgumentException(CONFIRMATION_PASSWORD_ERROR_MESSAGE);
        }
        User user = mapper.mapDtoToEntity(userDto);
        userRepository.save(user);
    }


    @Override
    public User login(String email, String password) {
        UserDto userDto = findByEmail(email);
        if (emailValidation(email)) {
            LOGGER.info(EMAIL_ERROR_MESSAGE);
            throw new IllegalArgumentException(EMAIL_ERROR_MESSAGE);
        }
        if (email.equals(userDto.getEmail()) && password.equals(userDto.getPassword())) {
            User user = new UserMapper().mapDtoToEntity(userDto);
            user.setPassword(StringUtils.EMPTY);
            return user;
        } else {
            throw new IllegalArgumentException(PASSWORD_ERROR_MESSAGE);
        }
    }

    private boolean emailValidation(String email) {
        String regExp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        return !email.matches(regExp);
    }

    private void execute(HttpServletRequest request, Integer codes) {

    }

}
