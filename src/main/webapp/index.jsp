<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>

<fmt:setLocale value="${sessionScope.langue}"/>

<fmt:bundle basename="langue">
    <%
    if(null == session.getAttribute("idPersonne")){
        %>
        <h3>User not logged in.</h3>
    <%
    }
    else
    { %>
        <h3>User logged in.</h3>
    <%
    }
    %>
    <jsp:include page="navbar.jsp" />

        <h1><fmt:message key="title"/></h1>
        <img style="width: 100%;text-align: center" src="images/hiring-contractor.jpg">

    <jsp:include page="footer.jsp"/>


</fmt:bundle>

<script src="js/scripts.js"/>


</body>
</html>