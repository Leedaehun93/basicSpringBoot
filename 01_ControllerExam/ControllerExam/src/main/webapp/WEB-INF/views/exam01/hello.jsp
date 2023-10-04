<%-- TODO : webapp.Web-INF.views.exam01 fileName : hello --%>
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

    <%-- TODO : 부트스트랩 css 링크 --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<%-- jsp 주석 --%>
<%-- TODO : el(Expression Language) 표현식 : ${변수명} --%>
<%--  자바 spring에서 전송한(Model) 키 값을 출력할 수 있음 --%>
<p>${greeting}</p>
<p>${greeting2}</p>
<p>${greeting3}</p>

<%-- TODO : JSTL 표현식(참고) : <c:out value="${변수명}" /> --%>
<p><c:out value="${greeting}"/></p>

</body>
</html>