<%@ page import="util.Util" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>

<div class="topnav" id="myTopnav">
    <ul>
        <li><a href="index.jsp" class="active"><fmt:message key="home"/></a></li>
<%--
        <li class="dropdown">
            <button class="dropbtn"><fmt:message key="accounts"/>
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="PersonneServlet">Register User</a>
                <a href="PersonneServlet">Register Professional</a>
                <a href="#">Search Person</a>
                <a href="#">List Users</a>
                <a href="#">List Professionals</a>
            </div>
        </li>
--%>
        <li class="dropdown">
            <button class="dropbtn"><fmt:message key="offre"/>
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="insertoffretravail.jsp"><fmt:message key="insert_work_offer"/></a>
                <a href="ListOffreTravailServlet"><fmt:message key="list_of_offerts"/></a>
                <a href="ListOffreTravailServlet"><fmt:message key="delete_offert"/></a>
                <a href="#"><fmt:message key="search_offert"/></a>
                <%--<a href="#">Create Soumission</a>--%>
                <%--<a href="#">List of Soumissions</a>--%>
                <%--<a href="#">Search Soumission</a>--%>
            </div>
        </li>
        <li class="dropdown">
            <button class="dropbtn">Message
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="MessageServlet?mode=inbox"><fmt:message key="inbox"/></a>
                <a href="MessageServlet?mode=sent"><fmt:message key="sent"/></a>
                <a href="MessageServlet?mode=compose"><fmt:message key="compose"/></a>
                <a href="MessageServlet?mode=search"><fmt:message key="search"/></a>
            </div>
        </li>
<%--
        <li class="dropdown">
            <button class="dropbtn">Evaluation
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="#">Evaluate work</a>
                <a href="#">List of Evaluation</a>
            </div>
        </li>
--%>
        <li class="dropdown">
            <button class="dropbtn"><fmt:message key="nature_travail"/>
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="insertnaturetravail.jsp"><fmt:message key="create"/></a>
                <%--<a href="#">List of Natures Travail</a>--%>
                <%--<a href="#">Search Nature Travail</a>--%>
            </div>
        </li>
        <li class="dropdown">
            <button class="dropbtn"><fmt:message key="language"/>
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="LangueServlet?lang=en_US"><fmt:message key="english"/></a>
                <a href="LangueServlet?lang=fr_FR"><fmt:message key="french"/></a>
                <a href="LangueServlet?lang=es_ES"><fmt:message key="spanish"/></a>
            </div>
        </li>
        <li>
            <% if (Util.isLoggedIn(session)) { %>
            <a href="LogoutServlet"><fmt:message key="logout"/></a>
            <% } else { %>
            <button class="dropbtn" onclick="window.location='login.jsp'" style="width:auto;">
                <fmt:message key="login"/>
            </button>
            <% } %>
        </li>
    </ul>
</div>
