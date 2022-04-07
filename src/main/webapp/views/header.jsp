<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<html lang="${param.language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<f:setLocale value="${sessionScope.language}"/>
<f:setBundle basename="resources"/>
<c:set var="pageName" value="/index.jsp"/>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light pb-2">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Hello Hotel</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">
                        <f:message key="home"></f:message>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="aboutUs.jsp">
                        <f:message key="about"></f:message>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contacts.jsp">
                        <f:message key="contacts"></f:message>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="loginPage.jsp">
                        <f:message key="login"></f:message>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="signIn.jsp">
                        <f:message key="signin"></f:message>
                    </a>
                </li>
            </ul>
            <form class="d-flex" method="post" onchange="submit()">
                <select class=" form-control select-size" id="language" name="language"
                        style="width: 120px;">
                    <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                    <option value="ua" ${language == 'ua' ? 'selected' : ''}>Україньська</option>
                </select>
            </form>
        </div>
        <p>Language:${language}</p>
    </div>
</nav>

</body>
</html>


