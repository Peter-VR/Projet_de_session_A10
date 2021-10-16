<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="langue"/>
<jsp:include page="header.jsp"/>

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

<jsp:include page="footer.jsp"/>
