<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>
<jsp:include page="header.jsp"/>

<h1><fmt:message key="title"/></h1>
<img style="margin-top:10px;width: 100%;text-align: center" src="images/hiring-contractor.jpg" alt="">

<jsp:include page="footer.jsp"/>
