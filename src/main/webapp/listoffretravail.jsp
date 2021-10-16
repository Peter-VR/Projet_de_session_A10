<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>
<jsp:include page="header.jsp"/>

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
                        <th><fmt:message key="creation"/></th>
                        <th><fmt:message key="modification"/></th>
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
                            <td>${element.datecreationoffre}</td>
                            <td>${element.datederniermodification}</td>
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
