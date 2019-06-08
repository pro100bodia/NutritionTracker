<%@ include file="jspf/header.jspf" %>
<%@ include file="jspf/menu.jspf" %>

<!-- Client Data -->
<div class="container" id="client-data">
    <div class="row">
        <div class="col-sm-3"><img src='<c:out value="${image}" default="../img/avatar/default.png" />'/></div>
        <div class="col-sm-5">
            <div class="row">
                <div class="col-sm-9">
                    <list>
                        <li><input id="personal-param-1" type="text"
                                   value='<fmt:message key="client.name" />:  <c:out value="${name}" />'/></li>
                        <li><input id="personal-param-2" type="text"
                                   value='<fmt:message key="client.age" />:  <c:out value="${age}" />'/></li>
                        <li><input id="personal-param-3" type="text"
                                   value='<fmt:message key="client.gender" />:  <c:out value="${gender}" />'/></li>
                        <li><input id="personal-param-4" type="text"
                                   value='<fmt:message key="client.height" />:  <c:out value="${height}" />'/></li>
                        <li><input id="personal-param-5" type="text"
                                   value='<fmt:message key="client.weight" />:  <c:out value="${weight}" />'/></li>
                        <li><input id="personal-param-6" type="text"
                                   value='<fmt:message key="client.lifestyle" />:  <c:out value="${lifeStyle}" />'/>
                        </li>
                    </list>
                </div>
                <div class="col-sm-3">
                    <button class="btn btn-default" onclick="enableInput()" type="button">
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
            <select id="" name="">
                c:forEach="foodList" value="food"
                <option>choose your food</option>
                <option>c: out food</option>
                <option>c: out food</option>
                <option>c: out food</option>
            </select>
        </div>
        <div class="col-sm-4">
            <button class="btn btn-default">
                <fmt:message key="add_custom"/>
            </button>
        </div>
        <div class="col-sm-4">
            <fmt:message key="amount"/>
            <input min="1" type="number" value="1">
        </div>
    </form>
</div>
<!-- End Add Food Form -->

<!-- Client`s plate -->
<h3>
    <fmt:message key="your_plate"/>
</h3><br>
<table class="plate-table">
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