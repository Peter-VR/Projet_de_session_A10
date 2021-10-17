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
        <div style="width: 60%;margin: auto;">
            <form action="InsertOffreTravailServlet" method="post">
                <div style="text-align: right" class="form-group">
                    <label for="nom">Nom:</label>
                    <input type="text" class="form-control" id="nom" name="nom" value="${offre.nom}">
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
                <label for="etat">Etat:${offre.etatoffre}</label>
                        <select id="etat" name="etat">
                            <option value="attend" ${offre.etatoffre == 'attend' ? 'selected' : ''}>Attend</option>
                            <option value="pris" ${offre.etatoffre == 'pris' ? 'selected' : ''}>Pris</option>
                            <option value="complete" ${offre.etatoffre == 'complete' ? 'selected' : ''}>Complete</option>
                            <option value="annule" ${offre.etatoffre == 'annule' ? 'selected' : ''}>Annule</option>

                        </select>
                </div>
                <input type="hidden" value="edit" name="edit" id="edit">
                <input type="hidden" value="${offre.idoffretravail}" name="idoffre" id="idoffre">
                <input type="hidden" value="${offre.datecreationoffre}" name="creation" id="creation">


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
    <%
        }
    %>

<jsp:include page="footer.jsp"/>
