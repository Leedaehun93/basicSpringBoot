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
<jsp:include page="../../common/header.jsp" />
<%--  header 끝 --%>

<div class="container mt-5">

    <div>
        <form action="/exam01/dept/edit/${dept.dno}" method="post">
<%--    TODO: springboot 에서 아래와 같이 hidden 값을 전송하면 :  put 방식으로 인식해서 연결해줌    --%>
            <input type="hidden" name="_method" value="put"/>

            <input type="hidden" name="dno" value="${dept.dno}"/>

            <div class="mb-3">
                <label for="dname" class="form-label">부서 이름</label>
                <input type="text"
                       class="form-control"
                       id="dname"
                       required
                       name="dname"
                       value="${dept.dname}"
                >
            </div>
            <div class="mb-3">
                <label for="loc" class="form-label">부서 위치</label>
                <input type="text"
                       class="form-control"
                       id="loc"
                       required
                       name="loc"
                       value="${dept.loc}"
                >
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </form>

        <%-- TODO 삭제 버튼 from --%>
        <form id="delete-form" action="/exam01/dept/delete/${dept.dno}" method="post">
            <%--    TODO: springboot 에서 아래와 같이 hidden 값을 전송하면 :  delete 방식으로 인식해서 연결해줌    --%>
            <input type="hidden" name="_method" value="delete"/>
            <button type="submit" class="btn btn-danger">Delete</button>
        </form>
    </div>

</div>

</div>

<script>
    let obj = "${dept}";
    console.log(obj);
</script>

<%-- header 시작 --%>
<jsp:include page="../../common/footer.jsp"/>
<%--  header 끝 --%>
</script>
</body>
</html>