<%--
  Created by IntelliJ IDEA.
  User: DELL-MARIO
  Date: 2021-10-07
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <title>Liste Offre Travail</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-6">
            <h1>Liste Offre Travail</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-9">
            <c:if test="${not empty mylist}">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Description</th>
                    <th scope="col">Etat Offre</th>
                    <th scope="col">Budget</th>
                    <th scope="col">Duree</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="element" items="${mylist}">
                    <tr>
                        <td scope="row">${element.idoffretravail}</td>
                        <td>${element.nom}</td>
                        <td>${element.description}</td>
                        <td>${element.etatoffre}</td>
                        <td>${element.budget}</td>
                        <td>${element.duree}</td>

                    </tr>
                </c:forEach>


                </tbody>
            </table>
            </c:if>
            <c:if test="${empty mylist}">
                <h2>Liste vide</h2>
            </c:if>
        </div>
    </div>
</div>


</body>
</html>
