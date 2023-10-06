<%-- TODO : webapp.Web-INF.views.exam01 fileName : hello--%>
<%-- 아래 page 지시자가 있어야 함 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- TODO : jstl 표현식 사용을 위한 import --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%-- TODO : bootstrap css cdn --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <%-- TODO: 매개변수(파라메터) 배열 전달받아 출력하기 --%>
    <h2>예제3 : URL 매개변수 3개를 전달해서 조건에 따라 출력하기</h2>
    <%--  TODO: el 표현식 --%>
    <p>${name}</p>
    <p>${color}</p>
    <p>${kind}</p>

    <%-- TODO : if 조건문으로 출력하기 : jstl 표현식, else 없음 --%>
    <%--  사용법 : <c:if test="${조건식}"> 실행문 </c:if> --%>
    <c:if test="${name == '삼식이'}">
        <p>삼식이가 맞습니다.</p>
    </c:if>

    <%-- TODO : choose 조건문으로 출력하기, else 있음 --%>
    <c:choose>
        <c:when test="${color == 'brown'}">
            갈색입니다.
        </c:when>
        <c:when test="${color == 'yellow'}">
            노란색입니다.
        </c:when>
        <c:otherwise>
            다른색입니다.
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>