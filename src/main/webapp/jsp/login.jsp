<%@ include file="jspf/header.jspf"%>

<form action="${pageContext.request.contextPath}/login" method="post">
    <p>
        <fmt:message key="error.login" var="error.login.message" />
        <i><c:out value="${error.login.message}" /></i>
    </p>
    <input name="userName" placeholder='<fmt:message key="login.user"/>' type="text">
    <input name="password" placeholder='<fmt:message key="login.password"/>' type="password">
    <input type="submit" value='<fmt:message key="login.login"/>'>
</form>


<%@ include file="jspf/footer.jspf"%>