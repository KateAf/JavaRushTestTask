<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CompPartsNewOrUpdate</title>

    <link href="resources/css/w3.css" rel="stylesheet">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue" style="background-color:blue">
    <h1>JavaRush TestTask</h1>
</div>
<div class="w3-container w3-padding">

    <div class="body">
        <h2>
            <strong>Описание компонента</strong>
        </h2>

        <form:form id="NewOrUpdate" modelAttribute="NewCompPartObject" method="post" action="saveCompPart">

        <div class="group">
            <div class="control-label col-xs-3"><form:label path="id">ID: </form:label></div>
            <label>
                <form:input class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" path="id"
                            value="${NewCompPartObject.id}"/>
            </label>

            <div class="control-label col-xs-3"><form:label path="description">Название: </form:label></div>
            <label>
                <form:input class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"
                            path="description" value="${NewCompPartObject.description}"/>
            </label>


            <div class="req"><form:label path="required">Необходимость: </form:label></div>
            <div>
                <input type="radio" name="required" value="true"/> Да
                <input type="radio" checked name="required" value="false"/> Нет
            </div>


            <div class="control-label col-xs-3"><form:label path="quantity">Количество:</form:label></div>
            <label>
                <form:input class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" path="quantity"
                            value="${NewCompPartObject.quantity}"/>
            </label>

            <div>
                <input type="submit" id="saveCompPart" class="button" value="SAVE"/>
            </div>

        </div>
    </div>

    </form:form>
</div>

</body>
</html>