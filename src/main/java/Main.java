import com.vladnickgofj.hotel.connection.HikariConnectionPool;
import com.vladnickgofj.hotel.dao.entity.Role;
import com.vladnickgofj.hotel.dao.entity.Room;
import com.vladnickgofj.hotel.dao.entity.User;
import com.vladnickgofj.hotel.dao.impl.RoomDaoImpl;
import com.vladnickgofj.hotel.dao.impl.UserDaoImpl;
import com.vladnickgofj.hotel.service.impl.UserServiceImpl;
import com.vladnickgofj.hotel.servlet.dto.UserDto;

import java.util.List;

public class Main {

    public static final Integer NUMBER = null;
    private static final int DEFAULT_USER_ROLE_ID = 2;

    public static void main(String[] args) {

        HikariConnectionPool hikariConnectionPool = new HikariConnectionPool("bd-config");

        UserDaoImpl userDao = new UserDaoImpl(hikariConnectionPool);
        RoomDaoImpl roomDao = new RoomDaoImpl(hikariConnectionPool);
        UserServiceImpl userService = new UserServiceImpl();

//        List<Room> all = roomDao.findAll();
        List<User> all1 = userDao.findAll();
//        roomDao.save(new Room(1, 2, 3, 1, 200, 1));
//        roomDao.update(new Room(2, 2, 3, 1, 170, 1));
//        User user = User.newBuilder()
//                .firstName("Roman")
//                .lastName("Babay")
//                .email("babay@test.com")
//                .password("123")
//                .role(Role.USER)
//                .build();
//        System.out.println(all);
        for (User user : all1) {
            System.out.println(user);

        }

    }
}
