<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:bundle basename="langue">

<div class="topnav" id="myTopnav">
  <a href="index.jsp" class="active">Accueil</a>
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
    <button class="dropbtn"><fmt:message key="offre"/>
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

  <div class="dropdown">
    <button class="dropbtn"><fmt:message key="language"/>
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="LangueServlet?lang=en_US"><fmt:message key="english"/></a>
      <a href="LangueServlet?lang=fr_FR"><fmt:message key="french"/></a>
      <a href="LangueServlet?lang=es_ES"><fmt:message key="spanish"/></a>
    </div>
  </div>
  <%
    if (null == session.getAttribute("idPersonne")) {
  %>
  <button class="dropbtn" onclick="window.location='login.jsp'" style="width:auto;">
    Login
  </button>
  <%
  } else { %>
  <a href="logoutServlet">Logout</a>
  <% }
  %>
</div>

</fmt:bundle>