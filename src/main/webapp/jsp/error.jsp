<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="ru"/>
<fmt:setBundle basename="error"/>

<html>
    <body>
        <h1>${errorCode}</h1>
        <h1><fmt:message key="message.404" /></h1>
    </body>
</html>