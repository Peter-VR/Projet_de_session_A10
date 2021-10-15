<%--
  Created by IntelliJ IDEA.
  User: HP-Desktop
  Date: 10/14/2021
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h1 style="text-align: center">LOGIN FORM</h1>


            <form class="modal-content animate" action="LoginServlet" method="post">
                <div class="imgcontainer">
                    <img src="images/pngtree-user.jpg" alt="Avatar" class="avatar">
                </div>

                <div class="container">
                    <label for="id"><b>Person ID</b></label>
                    <input type="text" placeholder="Enter ID" name="id" id="id" required>
                    <br/>
                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
                    <br/>
                    <button type="submit">Login</button>
                    <button type="reset" class="cancelbtn">Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>