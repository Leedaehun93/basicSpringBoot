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
<jsp:include page="../../common/header.jsp" />

<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">등록일자</th>
            <th scope="col">수정일자</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${dept.dno}</td>
            <td>${dept.dname}</td>
            <td>${dept.loc}</td>
            <td>${dept.insertTime}</td>
            <td>${dept.updateTime}</td>
        </tr>
        </tbody>
    </table>
</div>

<script>
    let obj = "${dept}";
    console.log(obj);
</script>

<jsp:include page="../../common/footer.jsp" />

</body>
</html>