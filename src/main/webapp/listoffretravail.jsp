<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

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
                <button class="dropbtn" onclick="window.location='login.jsp'" style="width:auto;">Login
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
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Description</th>
                        <th>Etat Offre</th>
                        <th>Budget</th>
                        <th>Duree</th>
                        <th>Option</th>
                    </tr>

                    <c:forEach var="element" items="${mylist}">
                        <tr>
                            <td>${element.idoffretravail}</td>
                            <td>${element.nom}</td>
                            <td>${element.description}</td>
                            <td>${element.etatoffre}</td>
                            <td>${element.budget}</td>
                            <td>${element.duree}</td>
                            <td><a href="DeleteOffreServlet?id=${element.idoffretravail}"><img class="option" src="images/delete.png"></a> </td>
                        </tr>
                    </c:forEach>

                </table>
            </c:if>
            <c:if test="${empty mylist}">
                <h2>Liste vide</h2>
            </c:if>
        </div>





    <%
        }
    %>




</fmt:bundle>

<script src="js/scripts.js"/>


</body>
</html>

