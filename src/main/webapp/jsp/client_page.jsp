<%@ include file="jspf/header.jspf" %>
<%@ include file="jspf/menu.jspf" %>

<!-- Client Data -->
<div class="container" id="client-data">
    <div class="row">
        <div class="col-sm-3"><img
                src='<c:out value="${image}" default="/nutrition_tracker/img/avatars/default.png" />'/></div>
        <div class="col-sm-5">
            <div class="row">
                <div class="col-sm-9">
                    <list class="personal_data">
                        <li><input id="client_id" name="id" type="hidden" value='<c:out value="${id}" />'></li>
                        <li><input disabled id="name"
                                   type="text" value='<fmt:message key="client.name" />:  <c:out value="${name}" />'/>
                        </li>
                        <li><input disabled id="age"
                                   type="text" value='<fmt:message key="client.age" />:  <c:out value="${age}" />'/>
                        </li>
                        <li><input disabled id="gender"
                                   type="hidden"
                                   value=<c:out value="${gender}"/>'/>
                        </li>
                        <li><input disabled id="gender_out"
                                   type="text"
                                   value='<fmt:message key="client.gender" />:  <fmt:message key="client.gender.${gender}" />'/>
                        </li>
                        <li><input disabled id="height"
                                   type="text"
                                   value='<fmt:message key="client.height" />:  <c:out value="${height}" />'/></li>
                        <li><input disabled id="weight"
                                   type="text"
                                   value='<fmt:message key="client.weight" />:  <c:out value="${weight}" />'/></li>
                        <li><input disabled id="lifeStyle"
                                   type="text"
                                   value='<fmt:message key="client.lifestyle" />:  <c:out value="${lifeStyle}" />'/>
                        </li>
                    </list>
                </div>
                <div class="col-sm-3">
                    <button class="btn btn-default" id="config_personal_data"
                            onclick="enableInput('${requestScope['javax.servlet.forward.request_uri']}')" type="button">
                        <span class="glyphicon glyphicon-cog"></span>
                    </button>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <a href="#calc">
                <fmt:message key="menu.calc"/>
            </a><br>
            <a href="#charts">
                <fmt:message key="menu.custom_food"/>
            </a><br>
            <a href="concrete_plate.jsp">
                <fmt:message key="menu.concrete_plate"/>
            </a>

            <form action="${pageContext.request.contextPath}/logout" method="post">
                <input type="submit" value="Log Out">
            </form>
        </div>
    </div>
</div>

<!-- End Client Data -->

<!-- Add Food Form -->
<div class="container" id="add-food-form">
    <form action="">
        <div class="col-sm-4">
            <select id="" name="food_selection">
                c:forEach="foodList" value="food"
                <option val="null">
                    <fmt:message key="food.empty"/>
                </option>
                <c:forEach items="${foodList}" var="food">
                    <option value="${food.id}">
                        <c:out value="${food.name}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-sm-4">
            <button class="btn btn-default">
                <fmt:message key="food.add_custom"/>
            </button>
            <button class="btn btn-default" onclick="addToPlate(food_selection.value)">
                <fmt:message key="food.add"/>
            </button>
        </div>
        <div class="col-sm-4">
            <fmt:message key="food.amount"/>
            <input min="1" type="number" value="1">
        </div>
    </form>
</div>
<!-- End Add Food Form -->

<!-- Client`s plate -->
<div class="column">
    <div class="row">
        <div class="col-sm-3">
            <h3>
                <fmt:message key="food.your_plate"/>
            </h3>
        </div>
        <div class="col-sm-6"></div>
        <div class="col-sm-3">
            <form action="">
                <input type="submit" value='<fmt:message key="menu.calc" />'>
            </form>
        </div>
    </div>
</div>

<table class="plate-table">
    <thead>
    <td>
        <fmt:message key="food.name"/>
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
        <fmt:message key="food.number"/>
    </td>
    <td>
        <fmt:message key="food.amount"/>
    </td>
    </thead>
    <tr>
        <td>name-1</td>
        <td>calories-1</td>
        <td>proteins-1</td>
        <td>fats-1</td>
        <td>carbohydrates-1</td>
        <td>number-1</td>
        <td>amount-1</td>
    </tr>
    <tr>
        <td>name-2</td>
        <td>calories-2</td>
        <td>proteins-2</td>
        <td>fats-2</td>
        <td>carbohydrates-2</td>
        <td>number-2</td>
        <td>amount-2</td>
    </tr>
    <tr>
        <td>name-3</td>
        <td>calories-3</td>
        <td>proteins-3</td>
        <td>fats-3</td>
        <td>carbohydrates-3</td>
        <td>number-3</td>
        <td>amount-3</td>
    </tr>
</table>
<!-- End Client`s plate -->

<%@ include file="jspf/footer.jspf" %>