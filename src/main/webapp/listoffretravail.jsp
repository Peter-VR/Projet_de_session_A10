<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste Offre Travail</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>

<fmt:setLocale value="${sessionScope.langue}"/>

<fmt:bundle basename="langue">
    <%
        if (null == session.getAttribute("idPersonne")) { %>
    <h3>User not logged in.</h3>
    <%
    } else { %>
    <h3>User logged in.</h3>
    <% }
    %>
    <jsp:include page="navbar.jsp" />

    <div class="container">
        <div class="row">
            <div class="col-6">
                <h1><fmt:message key="liste_offre_travail"/></h1>
            </div>
        </div>
        <%
            if (null == session.getAttribute("idPersonne")) { %>
        <div class="row">
            <div class="col-6">
                <button class="dropbtn" onclick="window.location='login.jsp'" style="width:auto;"><fmt:message key="login"/>
                </button>
            </div>
        </div>
        <%
        } else {
        %>

    </div>



    <div class="row">
        <div class="col-9">
            <c:if test="${not empty mylist}">
                <table class="table" id="offerts">
                    <tr>
                        <th><fmt:message key="ID"/></th>
                        <th><fmt:message key="name"/></th>
                        <th><fmt:message key="description"/></th>
                        <th><fmt:message key="etat_offer"/></th>
                        <th><fmt:message key="budget"/></th>
                        <th><fmt:message key="duree"/></th>
                        <th><fmt:message key="options"/></th>
                    </tr>

                    <c:forEach var="element" items="${mylist}">
                        <tr>
                            <td>${element.idoffretravail}</td>
                            <td>${element.nom}</td>
                            <td>${element.description}</td>
                            <td>${element.etatoffre}</td>
                            <td>${element.budget}</td>
                            <td>${element.duree}</td>
                            <td><a href="DeleteOffreServlet?id=${element.idoffretravail}"><img class="option" src="images/delete.png"></a>
                            <a href="EditOffreServlet?id=${element.idoffretravail}"><img class="option" src="images/edit.png"></a> </td>

                        </tr>
                    </c:forEach>

                </table>
            </c:if>
            <c:if test="${empty mylist}">
                <h2><fmt:message key="empty_list"/></h2>
            </c:if>
        </div>





    <%
        }
    %>

            <jsp:include page="footer.jsp"/>


</fmt:bundle>

<script src="js/scripts.js"/>


</body>
</html>

