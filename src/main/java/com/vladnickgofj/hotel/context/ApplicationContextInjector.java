package com.vladnickgofj.hotel.context;

import com.vladnickgofj.hotel.connection.HikariConnectionPool;
import com.vladnickgofj.hotel.controller.command.Command;
import com.vladnickgofj.hotel.controller.command.user.DefaultCommand;
import com.vladnickgofj.hotel.controller.command.user.LoginCommand;
import com.vladnickgofj.hotel.controller.command.user.RegisterCommand;
import com.vladnickgofj.hotel.dao.UserDao;
import com.vladnickgofj.hotel.dao.entity.User;
import com.vladnickgofj.hotel.dao.impl.UserDaoImpl;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.service.impl.UserServiceImpl;
import com.vladnickgofj.hotel.service.mapper.Mapper;
import com.vladnickgofj.hotel.service.mapper.UserMapper;
import com.vladnickgofj.hotel.servlet.dto.UserDto;
import com.vladnickgofj.hotel.validator.UserValidator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ApplicationContextInjector {

    private static final HikariConnectionPool HIKARI_CONNECTION_POOL = new HikariConnectionPool("bd-config");

    private static final UserDao USER_DAO = new UserDaoImpl(HIKARI_CONNECTION_POOL);

    private static final Mapper<UserDto, User> USER_MAPPER = new UserMapper();

    private static final UserValidator USER_VALIDATOR = new UserValidator();

    private static final UserService USER_SERVICE = new UserServiceImpl(HIKARI_CONNECTION_POOL, USER_DAO, USER_MAPPER, USER_VALIDATOR);

    private static final Command REGISTER_COMMAND =new RegisterCommand(USER_SERVICE);
    private static final Command LOGIN_COMMAND =new LoginCommand();
    private static final Command DEFAULT_COMMAND =new DefaultCommand();

    private static final Map<String, Command> USER_COMMAND_NAME_TO_COMMAND = initUserCommand();

    //private static final RoomService ROOM_SERVICE=new RoomServiceImpl();
    // TODO: 04.04.2022  create RegisterCommand
    // TODO: 04.04.2022 to create map with userCommands
    private static ApplicationContextInjector applicationContextInjector;

    private ApplicationContextInjector() {

    }

    // TODO: 04.04.2022 create methods for init map userCommands
    private static Map<String,Command> initUserCommand(){
        Map<String,Command> userCommandNameToCommand=new HashMap<>();
        userCommandNameToCommand.put("register",REGISTER_COMMAND);
        userCommandNameToCommand.put("login",LOGIN_COMMAND);
        userCommandNameToCommand.put("defaultCommand",DEFAULT_COMMAND);

        return Collections.unmodifiableMap(userCommandNameToCommand);
    }
    public static ApplicationContextInjector getInstance() {
        if (applicationContextInjector == null) {
            synchronized (ApplicationContextInjector.class) {
                if (applicationContextInjector == null) {
                    applicationContextInjector = new ApplicationContextInjector();
                }
            }
        }
        return applicationContextInjector;
    }
    public Map<String, Command> getUserCommands() {
        return USER_COMMAND_NAME_TO_COMMAND;
    }
    public UserService getUserService() {
        return USER_SERVICE;
    }

}
