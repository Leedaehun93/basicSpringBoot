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
        <form action="/exam01/emp/add" method="post">
            <%-- TODO : 사원명 --%>
            <div class="mb-3">
                <label for="ename" class="form-label">사원명</label>
                <input type="text" class="form-control" id="ename" required name="ename">
            </div>
            <%-- TODO : 직위 --%>
            <div class="mb-3">
                <label for="job" class="form-label">직위</label>
                <input type="text" class="form-control" id="job" required name="job">
            </div>
            <%-- TODO : 매니저 --%>
            <div class="mb-3">
                <label for="manager" class="form-label">매니저</label>
                <input type="number" class="form-control" id="manager" required name="manager">
            </div>
            <%-- TODO : 입사일 --%>
            <div class="mb-3">
                <label for="hiredate" class="form-label">입사일</label>
                <input type="text" class="form-control" id="hiredate" required name="hiredate">
            </div>
            <%-- TODO : 급여 --%>
            <div class="mb-3">
                <label for="salary" class="form-label">급여</label>
                <input type="number" class="form-control" id="salary" required name="salary">
            </div>
            <%-- TODO : 상여금 --%>
            <div class="mb-3">
                <label for="commission" class="form-label">상여금</label>
                <input type="text" class="form-control" id="commission" name="commission">
            </div>
            <%-- TODO : 부서번호 --%>
            <div class="mb-3">
                <label for="dno" class="form-label">부서번호</label>
                <input type="number" class="form-control" id="dno" required name="dno">
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