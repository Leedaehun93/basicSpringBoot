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
    <h2>연습 1 : URL 매개변수로 dno=10, dName=Accounting Loc=NewYork 받았다. 아래 결과를 화면에 출력하세요.</h2>
    <%--  TODO: el 표현식 --%>
    <p>${dno}</p>
    <p>${dname}</p>
    <p>${loc}</p>
</div>
</body>
</html>