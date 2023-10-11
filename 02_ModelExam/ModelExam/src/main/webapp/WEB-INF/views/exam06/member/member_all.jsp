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
<%--todo: header.jsp --%>
<jsp:include page="../../common/header.jsp" />

<%--todo : 본문 --%>
<div class="container">
    <h3>전달 받은 객체는 ${list} 입니다.</h3>

<%--    todo: 테이블 형태로 화면 출력 --%>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">사원번호</th>
            <th scope="col">사원명</th>
            <th scope="col">직위</th>
            <th scope="col">매니저</th>
            <th scope="col">등록일자</th>
            <th scope="col">수정일자</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="data" items="${list}">
            <tr>
                <td>
                     <a href="/exam06/member/edition/${data.eno}">${data.eno}</a>
                </td>
                <td>${data.ename}</td>
                <td>${data.job}</td>
                <td>${data.manager}</td>
                <td>${data.insertTime}</td>
                <td>${data.updateTime}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <%-- todo: Add 버튼 추가 --%>
    <div class="text-center">
        <a href="/exam06/member/addition" class="btn btn-primary">Add</a>
    </div>
</div>

<script>
    let obj = "${list}";
    console.log(obj);
</script>

<%--todo: footer.jsp--%>
<jsp:include page="../../common/footer.jsp" />

</body>
</html>









