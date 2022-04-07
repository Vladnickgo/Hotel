<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<f:setLocale value="${locale}"/>
<f:setBundle var="bunCont" basename="resources"/>
<c:set var="pageName" value="/signIn.jsp" scope="session"/>
<c:import url="views/header.jsp"/>
Email:${email}<br>
Session:${gmail}<br>
<c:out value="${gmail}"/><br>
<div class="container mt-5">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4" align="center">
            <h1 class="mb-5">
                <f:message key="userRegistration" bundle="${bunCont}"></f:message>
            </h1>
            <form action="/user" method="post">
                <label>
                    <input name="command" value="register" hidden>
                </label>
                <table>
                    <tr>
                        <td>
                            <f:message key="firstName" bundle="${bunCont}"></f:message><sup>*</sup>
                        </td>
                        <td>
                            <input type="text" name="firstName" value=${firstName}><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <f:message key="lastName" bundle="${bunCont}"></f:message><sup>*</sup>
                        </td>
                        <td>
                            <input type="text" name="lastName" value=${lastName}><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email<sup>*</sup>
                        </td>
                        <td>
                            <input type="text" name="email" value=${email}><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <f:message key="password" bundle="${bunCont}"></f:message><sup>*</sup>
                        </td>
                        <td>
                            <input type="password" name="password"><br>
                        </td>
                    </tr>
                    <tr>
                        <td pr-2>
                            <f:message key="passwordConfirmation" bundle="${bunCont}"></f:message><sup>*</sup>
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
                            <input type="submit" value=<f:message key="submit" bundle="${bunCont}"></f:message>>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-muted colspan-2">
                            <sup>*</sup> - <f:message key="requireFields" bundle="${bunCont}"></f:message>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <input type="text" name="pageName" value="signin" hidden>
                </table>
            </form>
        </div>
        <div class="col-4"></div>
    </div>
</div>

<c:import url="views/footer.jsp"/>
</body>
</html>
