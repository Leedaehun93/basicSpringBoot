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
<%-- todo: header --%>
<jsp:include page="../../common/header.jsp" />

<%-- todo: 본문--%>
<div class="container">
    <h3>전달받은 객체는 ${member} 입니다.</h3>
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
            <tr>
                <td>${member.eno}</td>
                <td>${member.ename}</td>
                <td>${member.job}</td>
                <td>${member.manager}</td>
                <td>${member.insertTime}</td>
                <td>${member.updateTime}</td>
            </tr>
        </tbody>
    </table>


</div>

<script>
    let obj = "${member}"
    console.log(obj);
</script>
<%-- todo: footer --%>
<jsp:include page="../../common/footer.jsp" />
</body>
</html>





