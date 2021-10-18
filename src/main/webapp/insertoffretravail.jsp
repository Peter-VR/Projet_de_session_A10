<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>
<jsp:include page="header.jsp"/>

        <div class="row">
            <div class="col-6">
                <h1><fmt:message key="insert_work_offer"/></h1>
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


    <div class="row">
        <div class="col-80">
            <form action="InsertOffreTravailServlet" method="post">
                <div style="text-align: right" class="form-group">
                    <label for="nom"><fmt:message key="name" />:</label>
                    <input type="text" class="form-control" id="nom" name="nom">
                </div>
                <div style="text-align: right" class="form-group">
                    <label for="description"><fmt:message key="description"/>:</label>
                    <input type="text" class="form-control" id="description" name="description">
                </div>
                <div style="text-align: right" class="form-group">
                    <label for="budget"><fmt:message key="budget"/>:</label>
                    <input type="text" class="form-control" id="budget" name="budget">
                </div>
                <div style="text-align: right" class="form-group">
                    <label for="duree"><fmt:message key="duree"/>:</label>
                    <input type="text" class="form-control" id="duree" name="duree">
                </div>


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
    <%
        }
    %>

<jsp:include page="footer.jsp"/>
