<%--
  Created by IntelliJ IDEA.
  User: DELL-MARIO
  Date: 2021-10-07
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Liste Offre Travail</title>
</head>
<body>

  <table border="2">

    <c:forEach var="element" items="${mylist}" >
      <tr>
        <td>${element.idoffretravail}</td>
        <td>${element.nom}</td>
        <td>${element.description}</td>
        <td>${element.etatoffre}</td>
        <td>${element.budget}</td>
        <td>${element.duree}</td>



      </tr>
    </c:forEach>
  </table>

</body>
</html>
