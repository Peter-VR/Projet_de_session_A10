<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

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
<fmt:setLocale value="en_US"/>
<fmt:bundle basename="langue">
    <%
        if (null == session.getAttribute("idPersonne")) {
            out.println("<h3>User not logged in.</h3>");

        } else {
            out.println("<h3>User logged in.</h3>");
        }
    %>
    <div class="topnav" id="myTopnav">
        <a href="index.jps" class="active">Accueil</a>
        <div class="dropdown">
            <button class="dropbtn">Accounts
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="#">Register User</a>
                <a href="#">Register Professional</a>
                <a href="#">Search Person</a>
                <a href="#">List Users</a>
                <a href="#">List Professionals</a>

            </div>
        </div>

        <div class="dropdown">
            <button class="dropbtn">Work Offerts
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="insertoffretravail.jsp"><fmt:message key="insert_work_offer"/></a>
                <a href="#">Search Work Offert</a>
                <a href="ListOffreTravailServlet"><fmt:message key="list_of_offerts"/></a>
                <a href="DeleteOfferServlet"><fmt:message key="delete_offert"/></a>
                <a href="#">Create Soumission</a>
                <a href="#">List of Soumissions</a>
                <a href="#">Search Soumission</a>

            </div>
        </div>
        <div class="dropdown">
            <button class="dropbtn">Communication
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="#">Send Message</a>
                <a href="#">List of Messages</a>
                <a href="#">Search Message</a>
                <a href="#">Evaluate work</a>
                <a href="#">List of Evaluation</a>

            </div>
        </div>
        <div class="dropdown">
            <button class="dropbtn">Nature Travail
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="#">Create new Nature Travail</a>
                <a href="#">List of Natures Travail</a>
                <a href="#">Search Nature Travail</a>

            </div>
        </div>


        <%
            if (null == session.getAttribute("idPersonne")) {
        %>
        <button class="dropbtn" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">
            Login
        </button>
        <%
        } else { %>
        <a href="LogoutServlet">Logout</a>
        <% }
        %>

        <div class="dropdown">
            <button class="dropbtn"><fmt:message key="language"/>
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="<fmt:setLocale value="en_US"/>"><fmt:message key="english"/></a>
                <a href="<fmt:setLocale value="fr_FR"/>"><fmt:message key="french"/></a>
                <a href="<fmt:setLocale value="es_ES"/>"><fmt:message key="spanish"/></a>
            </div>
        </div>
    </div>

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
                <button class="dropbtn" onclick="document.getElementById('id01').style.display='block'"
                        style="width:auto;">Login
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


    <div id="id01" class="modal">

        <form class="modal-content animate" action="LoginServlet" method="post">
            <div class="imgcontainer">
                <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                <img src="images/pngtree-user.jpg" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <label for="uname"><b>Person ID</b></label>
                <input type="text" placeholder="Enter ID" name="uname" id="uname" required>
                <br/>
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
                <br/>
                <button type="submit">Login</button>
                <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">
                    Cancel
                </button>


            </div>


        </form>
    </div>

</fmt:bundle>

<script src="js/scripts.js"/>
<script>
    // Get the modal
    var modal = document.getElementById('id01');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }


</script>

</body>
</html>





