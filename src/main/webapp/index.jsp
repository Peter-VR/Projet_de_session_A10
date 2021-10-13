<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<fmt:setLocale value="es_ES"/>
<fmt:bundle basename="langue">
    <%
    if(null == session.getAttribute("idPersonne")){
        out.println("<h3>User not logged in.</h3>");

    }
    else
    {
        out.println("<h3>User logged in.</h3>");
    }
    %>
    <div class="topnav" id="myTopnav">
        <a href="#home" class="active">Home</a>
        <a href="#news">News</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
        <%
            if(null == session.getAttribute("idPersonne")){
                out.println("<button onclick=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\">Login</button>");

            }
            else
            {
                out.println("<a href=\"logoutServlet\">Logout</a>");
            }
        %>

        <div class="dropdown">
            <button class="dropbtn"><fmt:message key="language"/>
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="#"><fmt:message key="english"/></a>
                <a href="#"><fmt:message key="french"/></a>
                <a href="#"><fmt:message key="spanish"/></a>
            </div>
        </div>
    </div>


<h1><fmt:message key="title"/></h1>


<br />
<a href="ListOffreTravailServlet"><fmt:message key="list_of_offerts"/></a>
<br/>
<a href="insertoffretravail.jsp"><fmt:message key="insert_work_offer"/></a>
</fmt:bundle>


<div id="id01" class="modal">

    <form class="modal-content animate" action="LoginServlet" method="post">
        <div class="imgcontainer">
            <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
            <img src="images/pngtree-user.jpg" alt="Avatar" class="avatar">
        </div>

        <div class="container">
            <label for="uname"><b>Person ID</b></label>
            <input type="text" placeholder="Enter Username" name="uname" id="uname" required>
            <br/>
            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
            <br/>
            <button type="submit">Login</button>
            <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>


        </div>


    </form>
</div>



<script src="js/scripts.js"/>
<script>
    // Get the modal
    var modal = document.getElementById('id01');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }


</script>

</body>
</html>