package com.vladnickgofj.hotel.service;

import com.vladnickgofj.hotel.controller.dto.UserDto;
import com.vladnickgofj.hotel.dao.entity.User;

public interface UserService {

    UserDto findByEmail(String email);

    void save(UserDto userDto);

    User login(String email, String password);
}
