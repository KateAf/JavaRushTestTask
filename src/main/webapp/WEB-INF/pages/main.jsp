<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JavaRushTestTask</title>
    <link href="resources/css/w3.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
</head>
<body class="w3-light-grey" >
<div class="w3-container w3-blue w3-opacity w3-right-align">

    <div class="w3-card-4">
        <div class="w3-container w3-blue" style="background-color:blue">
            <h1>JavaRush TestTask</h1>
        </div>
        <div class="body">


            <form action="searchCompPart">
                <div class="search">
                    <div class="find"><strong>Найти по наименованию:</strong></div>
                    <div class="find1"><input type="text" name="searchDescription" id="searchDescription" ></div>
                    <div class="button" ><input class="w3-button" type='submit' value='Найти'/>
                    </div>

                </div>
            </form>

            <form action="searchRequired">
                <div class="search" align="left">
                    <div class="requred1"><strong>Необходимость:</strong></div>

                    <div class="requred2">
                        <input type="radio" name="requirement" value="true"/> Да
                        <input type="radio" name="requirement" value="false"/> Нет
                        <input type="radio" checked name="requirement" value=""/> Все
                        <div class="button" ><input class="w3-button" type='submit' value='Выбор'/>
                        </div>

                    </div>

                </div>
            </form>


            <table class="table">
                <thead style="background-color: lightgray; color: white;">
                <tr>
                    <th>Удалить</th>
                    <th>Изменить</th>
                    <th>Наименование</th>
                    <th>Необходимость</th>
                    <th>Склад</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listcompparts}" var="parts">
                    <tr>
                        <th><a class="Delete" style="color:green;" href="deleteCompPart?id=<c:out value='${parts.id}'/>">Delete</a></th>
                        <th><a class="Edit" href="editCompPart?id=<c:out value='${parts.id}'/>">Update</a></th>

                        <th><c:out value='${parts.description}'/></th>
                        <th><c:out value='${parts.required == true ? "да" : "нет"}'/></th>
                        <th><c:out value='${parts.quantity}'/></th>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div>
                <table class="table" align="left">
                    <thead style="background-color: blue; color: white;">
                    <tbody>
                    <tr>
                        <th>Можно собрать</th>
                        <th><font  color="#00008b" face="Arial"><c:out  value='${computers}'/></font></th>
                        <th>компьютер(ов)</th>
                    </tr>
                    </tbody>
                </table>
            </div>
            <form action="createCompPart">
                <div class="create" align="right">
                    <div class="button"><input class="w3-button" type='submit' value='Добавить компонент'/>
                    </div>
                </div>
            </form>



        </div>





        <div align="center" class="panel-footer" style="background-color:lightgray" id="paging">
            <c:url value="/" var="prev">
                <c:param name="page" value="${page-1}"/>
            </c:url>
            <c:if test="${page > 1}">
                <a href="<c:out value="${prev}" />" class="pn prev"><< </a>
            </c:if>

            <c:forEach begin="1" end="${maxPages}" step="1" varStatus="j">
                <c:choose>
                    <c:when test="${page == j.index}">
                        <span>${j.index}</span>
                    </c:when>
                    <c:otherwise>
                        <c:url value="/" var="url">
                            <c:param name="page" value="${j.index}"/>
                        </c:url>
                        <a href='<c:out value="${url}" />'>${j.index}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:url value="/" var="next">
                <c:param name="page" value="${page + 1}"/>
            </c:url>
            <c:if test="${page + 1 <= maxPages}">
                <a href='<c:out value="${next}" />' class="pn next"> >></a>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>