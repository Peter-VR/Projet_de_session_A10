<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste Message</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="row">
    <div class="col-9">
        MessageList
        <c:choose>
            <c:when test="${empty list}">
                <h2>Liste vide</h2>
            </c:when>
            <c:otherwise>
                <table class="table" id="offerts">
                    <tr>
                        <th>ID</th>
                        <th>objet</th>
                        <th>contenu</th>
                        <th>date</th>
                        <th>etat</th>
                        <th>from</th>
                        <th>to</th>
                        <th>Option</th>
                    </tr>
                    <c:forEach var="element" items="${list}">
                        <tr>
                            <td>${element.idmessage}</td>
                            <td>${element.objet}</td>
                            <td>${element.contenu}</td>
                            <td>${element.datemessage}</td>
                            <td>${element.etatmessage}</td>
                            <td>${element.idpersonneenvoyer}</td>
                            <td>${element.idpersonnerecevoir}</td>
                            <td><a href="MessageDeleteServlet?id=${element.idmessage}">
                                <img class="option" src="images/delete.png"></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</body>
</html>
