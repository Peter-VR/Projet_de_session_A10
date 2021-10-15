
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/login.css">
    <title>LOGIN</title>
</head>
<body>

<fmt:setLocale value="${sessionScope.langue}"/>

<fmt:bundle basename="langue">

<div class="container">
    <div class="row">
        <div class="col-12 align-content-center">
            <h1 style="text-align: center"><fmt:message key="login_form"/></h1>


            <form class="modal-content animate" action="LoginServlet" method="post">
                <div class="imgcontainer">
                    <img src="images/pngtree-user.jpg" alt="Avatar" class="avatar">
                </div>

                <div class="container">
                    <label for="id"><b><fmt:message key="person_id"/></b></label>
                    <input type="text" placeholder="<fmt:message key="person_id"/>" name="id" id="id" required>
                    <br/>
                    <label for="psw"><b><fmt:message key="password"/></b></label>
                    <input type="password" placeholder="<fmt:message key="password"/>" name="psw" id="psw" required>
                    <br/>
                    <button type="submit"><fmt:message key="login"/></button>
                    <button type="reset" class="cancelbtn"><fmt:message key="reset"/></button>
                </div>
            </form>
        </div>
    </div>
</div>
</fmt:bundle>
</body>
</html>