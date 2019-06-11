<%@ include file="jspf/header.jspf"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import = "java.util.Enumeration" %>

<form action="${pageContext.request.contextPath}/login" method="post">
    <p>
        <i style="color: red;">
            <fmt:message key="${error_message}"/>
        </i>
    </p>

    <input name="userName" placeholder='<fmt:message key="login.user"/>' type="text">
    <input name="password" placeholder='<fmt:message key="login.password"/>' type="password">
    <input type="submit" value='<fmt:message key="login.login"/>'>
</form>


<%@ include file="jspf/footer.jspf"%>