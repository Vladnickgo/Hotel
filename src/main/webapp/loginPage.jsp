<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<f:setLocale value="${sessionScope.language}"/>

<f:setBundle var="bunCont" basename="resources"/>

<c:set var="Title" scope="request" value="LogIn"/>

<c:import url="views/head.jsp"/>

<body>
<c:import url="views/header.jsp"/>
<div class="container mt-5">
    <div class="row text-center">
        <div class="col-3"></div>
        <div class="col-6" align="center">
            <h1 class="mb-5">
                <f:message key="logForUsers" bundle="${bunCont}"/>
            </h1>
            <form action="home" method="post">
                <label>
                    <input name="command" value="login" hidden>
                </label>
                <table>
                    <tr>
                        <td>email</td>
                        <td><input type="text" value="${loginPageEmail}" name="email"></td>
                    </tr>
                    <tr>
                        <td>
                            <f:message key="password" bundle="${bunCont}"/>
                        </td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value=<f:message key="submit" bundle="${bunCont}"/>></td>
                    </tr>
                </table>
                <div class="alert alert-warning" style="${errorMessage==null?'display: none':'margin-top:10px'};">
                    <p><f:message key="authFailed" bundle="${bunCont}"/></p>
                    <p>${errroMessage}</p>
                </div>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>
<c:import url="views/footer.jsp"/>
</body>
</html>
