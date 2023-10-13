<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!-- thymeleaf 설정 -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%--  header 시작 --%>
<jsp:include page="../../common/header.jsp"/>
<%--  header 끝 --%>

<div class="container mt-5">
    <div>
        <%-- TODO : /exam01/dept/add 해당되는 컨트롤러 함수 실행 --%>
        <form action="/exam01/dept/add" method="post">
            <%-- TODO : 부서명 --%>
            <div class="mb-3">
                <label for="dname" class="form-label">부서이름</label>
                <input type="text" class="form-control" id="dname" required name="dname">
            </div>
            <%-- TODO : 부서위치 --%>
            <div class="mb-3">
                <label for="loc" class="form-label">부서위치</label>
                <input type="text" class="form-control" id="loc" required name="loc">
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</div>

<%--  header 시작 --%>
<jsp:include page="../../common/footer.jsp"/>
<%--  header 끝 --%>
</body>
</html>