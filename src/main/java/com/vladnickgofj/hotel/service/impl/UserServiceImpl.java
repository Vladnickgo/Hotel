package com.vladnickgofj.hotel.service.impl;

import com.vladnickgofj.hotel.HttpStatusCodes;
import com.vladnickgofj.hotel.connection.HikariConnectionPool;
import com.vladnickgofj.hotel.dao.UserDao;
import com.vladnickgofj.hotel.dao.entity.User;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.service.exception.EntityAlreadyExistException;
import com.vladnickgofj.hotel.service.exception.InvalidEmailException;
import com.vladnickgofj.hotel.service.mapper.Mapper;
import com.vladnickgofj.hotel.controller.dto.UserDto;
import com.vladnickgofj.hotel.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;


public class UserServiceImpl implements UserService {

    private final HikariConnectionPool hikariConnectionPool;
    private final UserDao userRepository;
    private final Mapper<UserDto, User> mapper;
    private final UserValidator userValidator;
    private HttpServletRequest request;

    public UserServiceImpl(HikariConnectionPool hikariConnectionPool, UserDao userRepository, Mapper<UserDto, User> mapper, UserValidator userValidator) {
        this.hikariConnectionPool = hikariConnectionPool;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.userValidator = userValidator;
    }

    @Override
    public UserDto findByEmail(String email) {
        userValidator.validateEmail(email);
        User user = userRepository.findByEmail(email).orElseThrow(() -> new InvalidEmailException("User with email [" + email + "] not found"));
        return mapper.mapEntityToDto(user);
    }

    @Override
    public void save(UserDto userDto) {
        System.out.println("Hello from UserServiceImpl, method save()");
        userValidator.validate(userDto);
        userRepository.findByEmail(userDto.getEmail()).ifPresent(err -> {
//            throw new RuntimeException("Email is not correct");
            execute(request,HttpStatusCodes.NOT_CORRECT_EMAIL);
            throw new InvalidEmailException("Email is not correct");
        });
        User user = mapper.mapDtoToEntity(userDto);
        userRepository.save(user);

    }

    @Override
    public void register(UserDto userDto) {
        userValidator.validate(userDto);
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new EntityAlreadyExistException("A user with this Email is already registered");
        }
    }

    private void execute(HttpServletRequest request, Integer codes) {
        request.setAttribute("statusCode", codes);
    }

}
