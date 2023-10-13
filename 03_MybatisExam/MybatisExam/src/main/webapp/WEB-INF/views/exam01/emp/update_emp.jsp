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
        <form action="/exam01/emp/edit/${emp.eno}" method="post">
            <%--    TODO: springboot 에서 아래와 같이 hidden 값을 전송하면 :  put 방식으로 인식해서 연결해줌    --%>
            <input type="hidden" name="_method" value="put"/>

            <input type="hidden" name="eno" value="${emp.eno}"/>

            <div class="mb-3">
                <label for="ename" class="form-label">사원명</label>
                <input type="text"
                       class="form-control"
                       id="ename"
                       required
                       name="ename"
                       value="${emp.ename}"
                >
            </div>
            <div class="mb-3">
                <label for="job" class="form-label">직위</label>
                <input type="text"
                       class="form-control"
                       id="job"
                       required
                       name="job"
                       value="${emp.job}"
                >
            </div>
            <div class="mb-3">
                <label for="manager" class="form-label">매니저</label>
                <input type="text"
                       class="form-control"
                       id="manager"
                       required
                       name="manager"
                       value="${emp.manager}"
                >
            </div>
            <div class="mb-3">
                <label for="hiredate" class="form-label">입사일</label>
                <input type="text"
                       class="form-control"
                       id="hiredate"
                       required
                       name="hiredate"
                       value="${emp.hiredate}"
                >
            </div>
            <div class="mb-3">
                <label for="salary" class="form-label">급여</label>
                <input type="text"
                       class="form-control"
                       id="salary"
                       required
                       name="salary"
                       value="${emp.salary}"
                >
            </div>
            <div class="mb-3">
                <label for="commission" class="form-label">상여금</label>
                <input type="text"
                       class="form-control"
                       id="commission"
                       required
                       name="commission"
                       value="${emp.commission}"
                >
            </div>
            <div class="mb-3">
                <label for="dno" class="form-label">부서번호</label>
                <input type="text"
                       class="form-control"
                       id="dno"
                       required
                       name="dno"
                       value="${emp.dno}"
                >
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </form>

        <%-- TODO 삭제 버튼 from --%>
        <form id="delete-form" action="/exam01/emp/delete/${emp.eno}" method="post">
            <%--    TODO: springboot 에서 아래와 같이 hidden 값을 전송하면 :  delete 방식으로 인식해서 연결해줌    --%>
            <input type="hidden" name="_method" value="delete"/>
            <button type="submit" class="btn btn-danger">Delete</button>
        </form>
    </div>

</div>

<script>
    let obj = "${emp}";
    console.log(obj);
</script>

<%--  header 시작 --%>
<jsp:include page="../../common/footer.jsp"/>
<%--  header 끝 --%>
</script>
</body>
</html>