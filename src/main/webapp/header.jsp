<%@ page import="util.Util" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css?1">
    <link rel="stylesheet" href="css/login.css?1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

    <% if (Util.isLoggedIn(session)) { %>
<h3>User logged in (id=${sessionScope.idPersonne})</h3>
    <% } else { %>
<h3 class="red">User not logged in</h3>
    <% } %>

<jsp:include page="navbar.jsp"/>
<div class="container">
