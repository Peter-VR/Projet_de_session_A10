<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
${sessionScope.langue}
<%

    if(null == session.getAttribute("langue")){
%>
<fmt:setLocale value="en_EN"/>
<%
}
else
{
    if(session.getAttribute("langue").equals("en_EN")) %>
        <fmt:setLocale value="en_EN"/>
    <% if(session.getAttribute("langue").equals("fr_FR")) %>
        <fmt:setLocale value="fr_FR"/>
    <% if(session.getAttribute("langue").equals("es_ES")) %>
        <fmt:setLocale value="es_ES"/>

<%
    }
%>
<%
    /*
<c:if test="${sessionScope.langue == null}">
    <fmt:setLocale value="en_EN"/>
</c:if>
<c:if test="${sessionScope.langue != null}">
    <fmt:setLocale value="${sessionScope.langue}"/>
</c:if>
*/
%>
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



</fmt:bundle>

<script src="js/scripts.js"/>


</body>
</html>