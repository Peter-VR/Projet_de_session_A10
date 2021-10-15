<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Inserter Offre Travail</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<fmt:setLocale value="${sessionScope.langue}"/>

<fmt:bundle basename="langue">
    <%
        if(null == session.getAttribute("idPersonne")){
    %>
    <h3>User not logged in.</h3>
    <%
    }
    else
    { %>
    <h3>User logged in.</h3>
    <%
        }
    %>
    <jsp:include page="navbar.jsp" />

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
    </div>
    <div class="row">
        <div class="col-6">
            <form action="InsertOffreTravailServlet" method="post">
                <div class="form-group">
                    <label for="nom">Nom:</label>
                    <input type="text" class="form-control" id="nom" name="nom">
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" class="form-control" id="description" name="description">
                </div>
                <div class="form-group">
                    <label for="budget">Budget:</label>
                    <input type="text" class="form-control" id="budget" name="budget">
                </div>
                <div class="form-group">
                    <label for="duree">Duree:</label>
                    <input type="text" class="form-control" id="duree" name="duree">
                </div>


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
    </div>
    <%
        }
    %>




</fmt:bundle>

<script src="js/scripts.js"/>


</body>
</html>





