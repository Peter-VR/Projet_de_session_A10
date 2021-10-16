<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>
<jsp:include page="header.jsp"/>

    <div class="container">
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


    </div>
    <div class="row">
        <div style="width: 60%;margin: auto;">
            <form action="InsertOffreTravailServlet" method="post">
                <div style="text-align: right" class="form-group">
                    <label for="nom">Nom:</label>
                    <input type="text" class="form-control" id="nom" name="nom" value="${offre.idoffretravail}">
                </div>
                <div style="text-align: right" class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" class="form-control" id="description" name="description" value="${offre.description}">
                </div>
                <div style="text-align: right" class="form-group">
                    <label for="budget">Budget:</label>
                    <input type="text" class="form-control" id="budget" name="budget" value="${offre.budget}">
                </div>
                <div style="text-align: right" class="form-group">
                    <label for="duree">Duree:</label>
                    <input type="text" class="form-control" id="duree" name="duree" value="${offre.duree}">
                </div>
                <div style="text-align: right" class="form-group">
                <label for="etat">Etat:</label>
                        <select id="etat" name="etat">
                            <option value="0">Select Status:</option>
                            <option value="1">attend</option>
                            <option value="2">pris</option>
                            <option value="3">complete</option>
                            <option value="4">annule</option>

                        </select>
                </div>



                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
    <%
        }
    %>

<jsp:include page="footer.jsp"/>
