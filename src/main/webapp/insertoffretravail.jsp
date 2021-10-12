<%--
  Created by IntelliJ IDEA.
  User: DELL-MARIO
  Date: 2021-10-08
  Time: 08:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


    <title>Inserter Offre Travail</title>
</head>
<body>
<h1>Insert Offre Travail</h1>
<div class="container">
    <div class="row">
        <div class="col-6">
<form>
    <div class="form-group">
        <label for="nom">Nom:</label>
        <input type="text" class="form-control" id="nom">
    </div>
    <div class="form-group">
        <label for="description">Description:</label>
        <input type="text" class="form-control" id="description">
    </div>
    <div class="form-group">
        <label for="budget">Budget:</label>
        <input type="text" class="form-control" id="budget">
    </div>
    <div class="form-group">
        <label for="duree">Duree:</label>
        <input type="text" class="form-control" id="duree">
    </div>


    <button type="submit" class="btn btn-primary">Submit</button>
</form>
    </div>
    </div>
</div>
</body>
</html>
