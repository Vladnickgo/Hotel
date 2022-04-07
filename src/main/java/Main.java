import com.vladnickgofj.hotel.connection.HikariConnectionPool;
import com.vladnickgofj.hotel.context.ApplicationContextInjector;
import com.vladnickgofj.hotel.dao.entity.Booking;
import com.vladnickgofj.hotel.dao.entity.Role;
import com.vladnickgofj.hotel.dao.entity.Room;
import com.vladnickgofj.hotel.dao.entity.User;
import com.vladnickgofj.hotel.dao.impl.BookingDaoImpl;
import com.vladnickgofj.hotel.dao.impl.RoomDaoImpl;
import com.vladnickgofj.hotel.dao.impl.UserDaoImpl;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.service.impl.UserServiceImpl;
import com.vladnickgofj.hotel.servlet.dto.UserDto;

import java.util.*;

public class Main {

    public static final Integer NUMBER = null;
    private static final int DEFAULT_USER_ROLE_ID = 2;

    public static void main(String[] args) {

        HikariConnectionPool hikariConnectionPool = new HikariConnectionPool("bd-config");

        UserDaoImpl userDao = new UserDaoImpl(hikariConnectionPool);
        RoomDaoImpl roomDao = new RoomDaoImpl(hikariConnectionPool);
        ApplicationContextInjector injector=ApplicationContextInjector.getInstance();
        UserService userService = injector.getUserService();
        BookingDaoImpl bookingDao = new BookingDaoImpl(hikariConnectionPool);

//        List<Room> all = roomDao.findAll();
        roomDao.update(new Room(2, 1, 2, 1, 150, 1));
        Optional<Room> byId = roomDao.findById(2);

//        List<User> all1 = userDao.findAll();
//        roomDao.save(new Room(1, 2, 3, 1, 200, 1));
//        User user = User.newBuilder()
//                .firstName("Roman")
//                .lastName("Babay")
//                .email("babay@test.com")
//                .password("123")
//                .role(Role.USER)
//                .build();
//        System.out.println(all);

//        List<Booking> all = bookingDao.findAll();
//        all
//                .stream()
//                .sorted(Comparator.comparing(Booking::getCheck_in).thenComparing(Booking::getNight))
//                .forEach(System.out::println);
//
//        System.out.println("-----------------------------");
//
//        bookingDao.findById(7).ifPresent(System.out::println);
        String[] resourcesArr = {"welcome", "home", "about", "contacts"};
        Locale[] locale ={new Locale("en", "US"),new Locale("ua","UA"),new Locale("ru","RU")};
        for (Locale loc : locale) {
            System.out.println(loc);
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", loc);
            for (String res : resourcesArr) {
                System.out.println("\t"+resourceBundle.getString(res));
            }
            System.out.println("---------------------------------------");
        }
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", locale);
//        String str = resourceBundle.getString("welcome");
//        System.out.println(locale);
//        System.out.println(str);
//        System.out.println(resourceBundle.getString("home"));
//        System.out.println(resourceBundle.getString("about"));
//        System.out.println(resourceBundle.getString("contacts"));

    }
}
