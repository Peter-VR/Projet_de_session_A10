<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<fmt:setLocale value="es_ES"/>
<fmt:bundle basename="langue">

    <div class="topnav" id="myTopnav">
        <a href="#home" class="active">Home</a>
        <a href="#news">News</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
        <div class="dropdown">
            <button class="dropbtn"><fmt:message key="language"/>
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="#"><fmt:message key="english"/></a>
                <a href="#"><fmt:message key="french"/></a>
                <a href="#"><fmt:message key="spanish"/></a>
            </div>
        </div>
    </div>


<h1><fmt:message key="title"/></h1>


<br />
<a href="ListOffreTravailServlet"><fmt:message key="list_of_offerts"/></a>
<br/>
<a href="insertoffretravail.jsp"><fmt:message key="insert_work_offer"/></a>
</fmt:bundle>

<script src="js/scripts.js"/>
</body>
</html>