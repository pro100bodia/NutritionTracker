<%@ include file="jspf/header.jspf" %>

<div id="doctor-name">
    <p>
        <fmt:message key="client.name"/>
        :
        <c:out value="${client_name}"/>
    </p>
</div>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Log Out">
</form>

<table>
    <thead>
    <td>
        <fmt:message key="client.name"/>
    </td>
    <td>
        <fmt:message key="food.calories"/>
    </td>
    <td>
        <fmt:message key="food.proteins"/>
    </td>
    <td>
        <fmt:message key="food.fats"/>
    </td>
    <td>
        <fmt:message key="food.carbohydrates"/>
    </td>
    <td>
        <fmt:message key="food.fav"/>
    </td>
    </thead>
    <c:forEach items="${clientStat}" var="record">
        <tr>
            <td style="padding-right: 4px;">
                <c:out value="${record.name}"/>
            </td>
            <td style="padding-right: 4px;">
                <c:out value="${record.averageDeflection.calories}"/>
            </td>
            <td style="padding-right: 4px;">
                <c:out value="${record.averageDeflection.protein}"/>
            </td>
            <td style="padding-right: 4px;">
                <c:out value="${record.averageDeflection.fat}"/>
            </td>
            <td style="padding-right: 4px;">
                <c:out value="${record.averageDeflection.carbohydrates}"/>
            </td>
            <td style="padding-right: 4px;">
                <c:out value="${record.favFood}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<list>
    <c:forEach items="${links}" var="link_num">
        <a href='${requestScope[' javax.servlet.forward.request_uri']}?page=
        <c:out value="${link_num}"/>
        '>
        <li class="inlined">
            <c:out value="${link_num}"/>
        </li>
        </a>
    </c:forEach>
</list>

<%@ include file="jspf/footer.jspf"%>