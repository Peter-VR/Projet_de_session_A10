<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>
<jsp:include page="header.jsp"/>

<div class="row">
    <div class="col-100">
        <h1><fmt:message key="title"/></h1>
    </div>
</div>
<div class="row">
    <div class="col-100">
        <img src="images/hiring-contractor.jpg" class="col-100" alt="">
    </div>
</div>

<jsp:include page="footer.jsp"/>
