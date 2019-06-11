<%@ include file="jspf/header.jspf" %>

<div id="doctor-name">
    <p>
        <c:out value="${name}"/>
    </p>
</div>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Log Out">
</form>

<%@ include file="jspf/footer.jspf"%>