<%-- TODO : webapp.Web-INF.views.exam01 fileName : operation --%>
<%-- 아래 page 지시자가 있어야 함 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- TODO : jstl 표현식 사용을 위한 import --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>산술연산자</title>

    <%-- TODO : 부트스트랩 css 링크 --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<%-- TODO : spring 에서 전송한 값으로 사칙연산, 논리연산 해보기--%>
<div class="container p-3">
    <h2>산술연산자</h2>
    <div class="ms-3 mt-3">
        <%-- TODO : 문자열로 생긴 숫자는 자동으로 형변환 됨 (사칙연산시) --%>
        <%--  jsp : java server page, 자바 문법 모두 사용가능 --%>
        <%--  jsp(.jsp) -> servlet(.java) --%>
        <P>덧셈 : ${strNum + 10}</P>
        <P>뺄셈 : ${strNum - 10}</P>
        <P>곱셈 : ${strNum * 10}</P>
        <P>나눗셈 : ${strNum / 10}</P>
        <P>나머지 : ${strNum % 10}</P>

        <P>숫자 연산 : ${iNum + 10}</P>

        <P>논리합 : ${bVal || false}</P>
        <P>논리곱 : ${bVal && false}</P>

        <P>같음 : ${iNum == 100}</P>
        <P>같지 않음 : ${iNum != 100}</P>
        <P>보다 큼 : ${iNum >= 100}</P>
        <P>보다 작음 : ${iNum <= 100}</P>

        <P>조건(3항) : ${(iNum == 100)? "100임" : "100이 아님"}</P>
    </div>
</div>

</body>
</html>