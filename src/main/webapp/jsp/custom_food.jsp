<%@ include file="jspf/header.jspf" %>
<%@ include file="jspf/menu.jspf" %>

<h3>
    <fmt:message key="menu.custom_food"/>
</h3>

<form action="${pageContext.request.contextPath}/custom_food">
    <list>
        <li><input name="food_name" type="text">
            <fmt:message key="food.name"/>
            <label for="food_name"></label></li>
        <li><input name="food_amount" type="text">
            <fmt:message key="food.amount"/>
            <label for="food_amount"></label></li>
        <li><input name="food_calories" type="text">
            <fmt:message key="food.calories"/>
            <label for="food_calories"></label></li>
        <li><input name="food_proteins" type="text">
            <fmt:message key="food.proteins"/>
            <label for="food_proteins"></label></li>
        <li><input name="food_fats" type="text">
            <fmt:message key="food.fats"/>
            <label for="food_fats"></label></li>
        <li><input name="food_carbohydrates" type="text">
            <fmt:message key="food.carbohydrates"/>
            <label for="food_carbohydrates"></label></li>
    </list>
    <input type="submit" value='<fmt:message key="food.add" />'/>
</form>

<%@ include file="jspf/footer.jspf" %>