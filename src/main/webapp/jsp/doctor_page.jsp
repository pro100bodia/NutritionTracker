<%@ include file="jspf/header.jspf" %>

<div id="doctor-name">
    <p>
        <c:out value="${name}"/>
    </p>
</div>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Log Out">
</form>

<p>
    <fmt:message key="coef_table"/>
</p>
<table>
    <c:forEach items="coefs" var="coef">
        <tr>
            <td>
                <c:out value="coef.name"/>
            </td>
            <td>
                <c:out value="coef.men"/>
            </td>
            <td>
                <c:out value="coef.women"/>
            </td>
        </tr>
    </c:forEach>
</table>

<table>
    <c:forEach items="foodList" var="food">
        <tr>
            <td>
                <c:out value="food.name"/>
            </td>
            <td>
                <c:out value="food.calories"/>
            </td>
            <td>
                <c:out value="food.protein"/>
            </td>
            <td>
                <c:out value="food.fats"/>
            </td>
            <td>
                <c:out value="food.carbohydrates"/>
            </td>
            <td>
                <c:out value="food.number"/>
            </td>
        </tr>

    </c:forEach>
</table>

<%@ include file="jspf/footer.jspf"%>