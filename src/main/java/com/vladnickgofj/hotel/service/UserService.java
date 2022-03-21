package com.vladnickgofj.hotel.service;

import com.vladnickgofj.hotel.servlet.dto.UserDto;

public interface UserService {
    UserDto findByEmail(String email);

    void save(UserDto userDto);

}
