<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>
<jsp:include page="header.jsp"/>

<div class="row">
    <div class="row">
        <div class="col-6">
            <h1><fmt:message key="message_list"/></h1>
        </div>
    </div>
    <div class="col-9">
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
                                <img class="option" src="images/delete.png" alt=""></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<jsp:include page="footer.jsp"/>
