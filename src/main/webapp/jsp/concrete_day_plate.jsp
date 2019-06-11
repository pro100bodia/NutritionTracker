<%@ include file="jspf/header.jspf" %>
<%@ include file="jspf/menu.jspf" %>

<h3>
    <fmt:message key="menu.concrete_plate"/>
</h3>
<list>
    <c:forEach items="${items}" var="date">
        <li>
            <c:out value="${date}"/>
            <!-- custom food tag here -->
        </li>
    </c:forEach>
</list>

<%@ include file="jspf/footer.jspf" %>
