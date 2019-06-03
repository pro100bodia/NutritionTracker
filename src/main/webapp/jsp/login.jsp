<%@ include file="jspf/header.jspf"%>

<form action="${pageContext.request.contextPath}/login" method="post">
    <p>
        <fmt: message key="" />
    </p>
    <input name="userName" placeholder='<fmt: message key="user"/>' type="text">
    <input name="password" placeholder='<fmt: message key="password"/>' type="password">
    <input type="submit" value='<fmt: message key="login"/>'>
</form>


<%@ include file="jspf/footer.jspf"%>