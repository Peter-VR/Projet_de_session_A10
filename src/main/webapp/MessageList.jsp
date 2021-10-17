<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>
<jsp:include page="header.jsp"/>

<div class="row">
    <div class="col-100">
        <h1><fmt:message key="${param.mode}"/></h1>
    </div>
</div>
<div class="row">
    <div class="col-100">
        <c:choose>
            <c:when test="${empty list}">
                <h2><fmt:message key="empty_list"/></h2>
            </c:when>
            <c:otherwise>
                <table class="table" id="tbl">
                    <tr>
                        <th><fmt:message key="ID"/></th>
                        <th><fmt:message key="Subject"/></th>
                        <th><fmt:message key="Content"/></th>
                        <th><fmt:message key="date"/></th>
                        <th><fmt:message key="FromUserId"/></th>
                        <th><fmt:message key="ToUserId"/></th>
                        <th><fmt:message key="options"/></th>
                    </tr>
                    <c:forEach var="element" items="${list}">
                        <tr>
                            <td>${element.idmessage}</td>
                            <td>${element.objet}</td>
                            <td>${element.contenu}</td>
                            <td>${element.datemessage}</td>
                            <td>${element.idpersonneenvoyer}</td>
                            <td>${element.idpersonnerecevoir}</td>
                            <td><a href="MessageServlet?mode=delete&id=${element.idmessage}">
                                <img class="option" src="images/delete.png" alt=""></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<jsp:include page="footer.jsp"/>
