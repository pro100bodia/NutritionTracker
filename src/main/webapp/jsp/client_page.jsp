<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


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
                        <li><input id="personal-param-1" type="text" value='<c:out value="${name}" />'/></li>
                        <li><input id="personal-param-2" type="text" value='<c:out value="${age}" />'/></li>
                        <li><input id="personal-param-3" type="text" value='<c:out value="${gender}" />'/></li>
                        <li><input id="personal-param-4" type="text" value='<c:out value="${height}" />'/></li>
                        <li><input id="personal-param-5" type="text" value='<c:out value="${weight}" />'/></li>
                        <li><input id="personal-param-6" type="text" value='<c:out value="${lifeStyle}" />'/></li>
                    </list>
                </div>
                <div class="col-sm-3">
                    <button class="btn btn-default" type="button">
                        <span class="glyphicon glyphicon-cog"></span>
                    </button>
                </div>
            </div>

        </div>
        <div class="col-sm-4">
            <a href="">watch deflection charts</a>
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
            <button class="btn btn-default">Add Custom</button>
        </div>
        <div class="col-sm-4">
            amount: <input min="1" type="number" value="1">
        </div>
    </form>
</div>
<!-- End Add Food Form -->

<!-- Client`s plate -->
<h3>Your plate:</h3><br>
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