<%--
  Created by IntelliJ IDEA.
  User: Computer
  Date: 30.03.2022
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<f:setLocale value="${locale}"/>
<f:setBundle var="bunCont" basename="resources"/>
<c:set var="pageName" value="/index.jsp" scope="session"/>
<c:import url="views/header.jsp"/>
Email:${email}

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
<c:import url="views/footer.jsp"/>
</body>
</html>