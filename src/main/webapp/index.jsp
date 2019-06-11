<%@ include file="jsp/jspf/header.jspf"%>
<%@ include file="jsp/jspf/menu.jspf"%>
<h1><fmt:message key="message.welcome"/></h1>
<a href="/nutrition_tracker/login">
    <fmt:message key="login.login"/>
</a>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value='<fmt:message key="login.logout" />'>
</form>
<%@ include file="jsp/jspf/footer.jspf"%>
