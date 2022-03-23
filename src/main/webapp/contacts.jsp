<%--
  Created by IntelliJ IDEA.
  User: Computer
  Date: 19.03.2022
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
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
    <title>LoginPage</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light pb-2">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Hello Hotel</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="aboutUs.jsp">AboutUs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contacts.jsp">Contacts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/loginPage.jsp">LogIn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/signIn.jsp">SignIn</a>
                </li>
            </ul>
            <form class="d-flex">
                <select class="form-select" aria-label="Default select example">
                    <%--                    <option selected>Open this select menu</option>--%>
                    <option value="1">укр</option>
                    <option value="2">eng</option>
                </select>
            </form>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="row text-center">
        <div class="col-4"></div>
        <div class="col-4">
            <h1 class="mb-5">Contacts</h1>
        </div>
        <div class="col-4"></div>
    </div>
</div>

<div class="container mt-1">
    <div class="row text-center">
        <div class="col-4"></div>
        <div class="col-4">
            <h3 class="mt-3">Address</h3>
            Our address
            <h3 class="mt-5">Telephones</h3>
            +(380)99-876-56-32<br>
            +(380)99-876-56-33<br>
            +(380)99-876-56-34<br>
            <h3 class="mt-5">Email</h3>
            test@test.ua<br>
            test@test.ua<br>
            test@test.ua<br>
        </div>
        <div class="col-4"></div>
    </div>
</div>

</body>
</html>
