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
<jsp:include page="../../common/header.jsp"/>

<div class="container">
    <%-- TODO : post 방식으로 백엔드 연결 --%>
    <form action="/exam04/dept/add" method="post">
        <%-- TODO : 부서명 입력양식 --%>
        <div class="mb-3">
            <label for="dname" class="form-label">부서 이름</label>
            <input type="text" class="form-control" id="dname" required name="dname">
        </div>
        <%-- TODO : 부서위치 입력양식 --%>
        <div class="mb-3">
            <label for="loc" class="form-label">부서 위치</label>
            <input type="text" class="form-control" id="loc" required name="loc">
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>

</div>

<jsp:include page="../../common/footer.jsp"/>
</body>
</html>