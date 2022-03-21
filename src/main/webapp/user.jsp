<%--
  Created by IntelliJ IDEA.
  User: Computer
  Date: 31.01.2022
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User_Page</title>
</head>
<body>
<a href="loginPage.jsp">logIn</a>
<form action="hello-servlet" method="post">
    <h2>User registration</h2>
    <table>
        <tr>
            <td>
               First Name
            </td>
            <td>
                <input type="text" name="firstName" value=${firstName}><br>
            </td>
        </tr>
        <tr>
            <td>
                Last Name
            </td>
            <td>
                <input type="text" name="lastName" value=${lastName}><br>
            </td>
        </tr>
        <tr>
            <td>
                Email
            </td>
            <td>
                <input type="text" name="email" value=${email}><br>
            </td>
        </tr>
        <tr>
            <td>
                Password
            </td>
            <td>
                <input type="password" name="password"><br>
            </td>
        </tr>
        <tr>
            <td>
                Password confirmation
            </td>
            <td>
                <input type="password" name="confirmationPassword"><br>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>${confirmationPassword}
            ${message}</td>
        </tr>
        <tr>
            <td>
                <label></label>
            </td>
            <td>
                <input type="submit" value="Submit...">
            </td>
        </tr>
        <input type="text" name="option" value="registration" hidden>
    </table>
</form>
</body>
</html>
