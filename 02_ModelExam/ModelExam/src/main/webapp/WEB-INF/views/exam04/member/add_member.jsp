<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<%-- header 시작 --%>
<jsp:include page="../../common/header.jsp"/>

<%-- 본문 --%>
<div class="container">
    <form action="/exam04/member/add" method="post">
        <%--        todo: 사원명 입력양식 --%>
        <div class="mb-3">
            <label for="ename" class="form-label">사원 이름</label>
            <input type="text" class="form-control" id="ename" required name="ename">
        </div>
        <%--       todo: 직위 입력양식--%>
        <div class="mb-3">
            <label for="job" class="form-label">부서 위치</label>
            <input type="text" class="form-control" id="job" required name="job">
        </div>
        <%--       todo: 매니저 입력양식--%>
        <div class="mb-3">
            <label for="manager" class="form-label">매니저</label>
            <input type="text" class="form-control" id="manager" required name="manager">
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
<jsp:include page="../../common/footer.jsp"/>
</body>
</html>