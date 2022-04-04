package com.vladnickgofj.hotel.servlet;

import com.vladnickgofj.hotel.dao.entity.Role;
import com.vladnickgofj.hotel.service.UserService;
import com.vladnickgofj.hotel.service.impl.UserServiceImpl;
import com.vladnickgofj.hotel.servlet.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String pageName = req.getParameter("pageName");
        req.setAttribute("session",session);
        System.out.println(pageName);
        switch (pageName) {
            case "signin":
                doSignin(req, resp);
                break;
            case "login":
                doLogin(req, resp);
                break;
        }
    }

    private void doSignin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmationPassword = req.getParameter("confirmationPassword");
        req.setAttribute("firstName", firstName);
        req.setAttribute("lastName", lastName);
        req.setAttribute("email", email);
        String param = req.getParameter("option");
        req.setAttribute("message", param);

        if (emailValidation(req, resp, email))
            getServletContext().getRequestDispatcher("/signIn.jsp").forward(req, resp);

        if (!Objects.equals(password, confirmationPassword) || Objects.equals(password, "")) {
            // TODO: 03.03.2022 DO something
            // TODO: 03.03.2022 send msg "Password not Equal"
            req.setAttribute("confirmationPassword", "Password not Equal");
            getServletContext().getRequestDispatcher("/signIn.jsp").forward(req, resp);
            return;
        }
        UserDto userDto = new UserDto(1, firstName, lastName, email, password, confirmationPassword, Role.USER);
        userService.save(userDto);
        getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);
    }

    private boolean emailValidation(HttpServletRequest req, HttpServletResponse resp, String email) throws ServletException, IOException {
        String regExp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        if (!email.matches(regExp)) {
            req.setAttribute("message", "email is not correct");
            return true;
        }
        return false;
    }

    //todo example
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String[] langArray = req.getParameter("lang").split("_");
        String language = langArray[0];
        String country = langArray[1];
        Locale locale = new Locale(language, country);
        String pageName = req.getParameter("pageName");
        System.out.println(pageName);
        HttpSession session = req.getSession();
        session.setAttribute("lang", Objects.equals(language, "ua") ? "укр" : "eng");
        session.setAttribute("optionUkr", Objects.equals(language, "ua") ? "selected" : "n");
        session.setAttribute("optionEng", Objects.equals(language, "en") ? "selected" : "n");
        session.setAttribute("country", locale.getDisplayCountry());
        session.setAttribute("locale", locale);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", locale);
        req.setAttribute("welcome", resourceBundle.getString("welcome"));
        getServletContext().getRequestDispatcher(pageName).forward(req, resp);
    }

    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        UserDto byEmail = userService.findByEmail(email);
        if (emailValidation(req, resp, email)) {
            req.setAttribute("message", "Email is not correct");
            getServletContext().getRequestDispatcher("/loginPage.jsp").forward(req, resp);
        }
        if (email.equals(byEmail.getEmail()) && pass.equals(byEmail.getPassword())) {
//            req.setAttribute("firstName", byEmail.getFirstName());
//            req.setAttribute("lastName", byEmail.getLastName());
//            req.setAttribute("email", email);
//            req.setAttribute("password", byEmail.getPassword());
//            req.setAttribute("confirmationPassword", byEmail.getConfirmationPassword());
//            req.setAttribute("role", byEmail.getRole());


            session.setAttribute("firstName", byEmail.getFirstName());
            session.setAttribute("lastName", byEmail.getLastName());
            session.setAttribute("email", email);
            session.setAttribute("password", byEmail.getPassword());
            session.setAttribute("confirmationPassword", byEmail.getConfirmationPassword());
            session.setAttribute("role", byEmail.getRole());

            getServletContext().getRequestDispatcher("/userPage.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Login/password is not correct");
            getServletContext().getRequestDispatcher("/loginPage.jsp").forward(req, resp);
        }
    }
}