<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13/10/2021
  Time: 2:10 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


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
            <h1>Insert <fmt:message key="nature_travail"/></h1>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <form action="InsertNatureTravailServlet" method="post">
                <div class="form-group">
                    <label for="nom">Nom:</label>
                    <input type="text" class="form-control" id="nom" name="nom">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
    <jsp:include page="footer.jsp"/>

</fmt:bundle>
</body>
</html>
