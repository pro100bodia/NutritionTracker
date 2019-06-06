<%@ include file="jspf/header.jspf"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import = "java.util.Enumeration" %>

<pre>
<%
    Enumeration names = request.getAttributeNames();
    while(names.hasMoreElements()){
        String name = (String) names.nextElement();
        String value = (String) request.getAttribute(name);
        out.println(name + ": " + value);
    }
%>
</pre>

<form action="${pageContext.request.contextPath}/login" method="post">
    <p>
        <c:catch var="exception">
            <i style="color: red;">
                <c:out value="${error_login_message}"/>
            </i>
            <fmt:message key="error.login" var="error_login_message"/>
        </c:catch>
    </p>

    <input name="userName" placeholder='<fmt:message key="login.user"/>' type="text">
    <input name="password" placeholder='<fmt:message key="login.password"/>' type="password">
    <input type="submit" value='<fmt:message key="login.login"/>'>
</form>


<%@ include file="jspf/footer.jspf"%>