<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<f:setLocale value="${sessionScope.language}"/>

<f:setBundle var="bunCont" basename="resources"/>

<c:set var="Title" scope="request" value="SignIn"/>

<c:import url="views/head.jsp"/>

<body>

<c:import url="views/header.jsp"/>

<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
    </symbol>
    <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
    </symbol>
    <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
    </symbol>
</svg>


<div class="container mt-5">
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6" align="center">
            <h1 class="mb-5">
                <f:message key="userRegistration" bundle="${bunCont}"></f:message>
            </h1>
            <form action="home" method="post">
                <label>
                    <input name="command" value="register" hidden>
                </label>
                <table>
                    <tr>
                        <td>
                            <f:message key="firstName" bundle="${bunCont}"></f:message><sup>*</sup>
                        </td>
                        <td>
                            <input type="text" name="firstName" placeholder="Ivan" value=${firstName}><br>
                        </td>
                        <td style="${notValidFirstName==null?'display:none':''}">
                            <f:message key="notValidFirstName" bundle="${bunCont}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <f:message key="lastName" bundle="${bunCont}"></f:message><sup>*</sup>
                        </td>
                        <td>
                            <input type="text" name="lastName" placeholder="Ivanov" value=${lastName}><br>
                        </td>
                        <td style="${notValidLastName==null?'display:none':''}">
                            <f:message key="notValidLastName" bundle="${bunCont}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email<sup>*</sup>
                        </td>
                        <td>
                            <input type="text" name="email" placeholder="example@gmail.com" value=${email}><br>
                        </td>
                        <td style="${notValidEmail==null?'display:none':''}">
                            <f:message key="notValidEmail" bundle="${bunCont}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <f:message key="password" bundle="${bunCont}"></f:message><sup>*</sup>
                        </td>
                        <td>
                            <input type="text" name="password"><br>
                        </td>
                        <td style="${notValidPassword==null?'display:none':''}">
                            <f:message key="notValidPassword" bundle="${bunCont}"/>
                        </td>
                    </tr>
                    <tr>
                        <td pr-2>
                            <f:message key="passwordConfirmation" bundle="${bunCont}"/><sup>*</sup>
                        </td>
                        <td>
                            <input type="text" name="confirmationPassword"><br>
                        </td>
                        <td style="${notValidConfirmPassword==null?'display:none':''}">
                            <f:message key="notValidConfirmPassword" bundle="${bunCont}"/>
                        </td>
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
                            <sup>*</sup> - <f:message key="requireFields" bundle="${bunCont}"/>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="alert alert-danger"
<%--                            style="${confirmationPassword==null?'display:none':''}">--%>
<%--                            <f:message key="confirmationPassword" bundle="${bunCont}"/>--%>
                            style="${userAlreadyExist==null?'display:none':''}">
                            <f:message key="userExists" bundle="${bunCont}"/>

                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="${userSaved==null?'display:none':''}">
                            <div class="alert alert-success d-flex align-items-center" role="alert">
                                <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img"
                                     aria-label="Success:">
                                    <use xlink:href="#check-circle-fill"/>
                                </svg>
                                <div>
                                    <f:message key="userSaved" bundle="${bunCont}"/>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
            <div style="color: red;font-weight: bolder; ${isAlreadyExist==null?'display: none':''}"><f:message
                    key="userExists" bundle="${bunCont}"/></div>
        </div>
        <div class="col-3"></div>
    </div>
</div>

<c:import url="views/footer.jsp"/>
</body>
</html>
