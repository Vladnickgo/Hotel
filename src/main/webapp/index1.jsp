<%--
  Created by IntelliJ IDEA.
  User: Computer
  Date: 30.03.2022
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--// Основные теги создания циклов, определения условий, вывода информации на страницу и т.д.--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--// Теги для работы с XML-документами--%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%--// Теги для работы с базами данных--%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>

<%--// Теги для форматирования и интернационализации информации (i10n и i18n)--%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <style type="text/css">
        /*#content {*/
        /*    width: 500px; !* Ширина слоя *!*/
        /*    margin: 0 auto 50px; !* Выравнивание по центру *!*/
        /*}*/
        footer {
            position: fixed; /* Фиксированное положение */
            left: 0;
            bottom: 0; /* Левый нижний угол */
            padding: 10px; /* Поля вокруг текста */
            background: #F8F9FA; /* Цвет фона */
            color: darkgray; /* Цвет текста */
            width: 100%; /* Ширина слоя */
        }
    </style>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <title>HomePage</title>
</head>
<f:setLocale value="${locale}"/>
<f:setBundle var="bunCont" basename="resources"/>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light pb-2">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Hello Hotel</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/views/index1.jsp">
                        <f:message key="home" bundle="${bunCont}"></f:message>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/views/aboutUs.jsp">
                        <f:message key="about" bundle="${bunCont}"></f:message>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/views/contacts.jsp">
                        <f:message key="contacts" bundle="${bunCont}"></f:message>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/views/loginPage.jsp">LogIn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/views/signIn.jsp">SignIn</a>
                </li>
            </ul>

            <form class="d-flex" action="${pageContext.request.contextPath}/hello-servlet" method="get" onchange="submit()">
                <select class="form-select" aria-label="Default select example" name="lang">
                    <option selected value="ua_UA" ${optionUkr}>укр</option>
                    <option value="en_US" ${optionEng}>eng</option>
                </select>
                <input type="text" name="pageName" value="index1.jsp" hidden>
            </form>
        </div>
    </div>
</nav>

<div class="container mt-5 mb-5 pb-5">
    <div class="row text-center">
        <div class="col-4"></div>
        <div class="col-4">
            <h1>Hello Hotel</h1>
        </div>
        <div class="col-4"></div>
    </div>
</div>

<div class="container mt-5 pt-5">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4 text-center">
            <%--            <h1 class="display-1">Welcome*</h1>--%>
            <h1 class="display-1"><f:message key="welcome" bundle="${bunCont}"></f:message></h1>
            <h2 class="mt-5">☆ ☆ ☆ ☆ ☆</h2>
        </div>
        <div class="col-4"></div>
    </div>
</div>
<footer>
    Designed by Vladimir Golubkov, 2022
</footer>
</body>
</html>



