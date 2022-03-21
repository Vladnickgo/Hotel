package com.vladnickgofj.hotel.service.impl;

import com.vladnickgofj.hotel.connection.HikariConnectionPool;
import com.vladnickgofj.hotel.dao.UserDao;
import com.vladnickgofj.hotel.dao.entity.User;
import com.vladnickgofj.hotel.dao.impl.UserDaoImpl;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.service.mapper.Mapper;
import com.vladnickgofj.hotel.service.mapper.UserMapper;
import com.vladnickgofj.hotel.servlet.dto.UserDto;
import com.vladnickgofj.hotel.validator.UserValidator;

import java.util.List;
import java.util.Optional;

import static java.lang.System.*;
import static java.util.Objects.nonNull;


public class UserServiceImpl implements UserService {
    private final HikariConnectionPool hikariConnectionPool = new HikariConnectionPool("bd-config");
    private final UserDao userRepository = new UserDaoImpl(hikariConnectionPool);
    private final Mapper<UserDto, User> mapper = new UserMapper();
    private final UserValidator userValidator=new UserValidator();

    @Override
    public UserDto findByEmail(String email) {
        userValidator.validateEmail(email);
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User with email [" + email + "] not found"));
        return mapper.mapEntityToDto(user);
    }

    @Override
    public void save(UserDto userDto) {
        userValidator.validate(userDto);
        userRepository.findByEmail(userDto.getEmail()).ifPresent(err->{throw new RuntimeException("Email is not correct");});
        User user = mapper.mapDtoToEntity(userDto);
        userRepository.save(user);
        out.println("User is saved");

    }

}
