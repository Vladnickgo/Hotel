<%--
  Created by IntelliJ IDEA.
  User: Computer
  Date: 19.03.2022
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginPage</title>
</head>
<body>
<div align="center">
  <a href="user.jsp">SignIn</a>
<h1>Hotel</h1>
<form action="hello-servlet" method="get" >
  <table>
    <tr>
      <td>email</td>
      <td><input type="text" name="email"></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="password"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Submit..."></td>
      ${message}
    </tr>
    <input type="text" name="option" value="entry" hidden>
  </table>
</form>
</div>
</body>
</html>
