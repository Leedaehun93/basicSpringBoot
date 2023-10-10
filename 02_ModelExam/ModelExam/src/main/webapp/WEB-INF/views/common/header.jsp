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
    <!-- bootstrap css cdn -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <%-- main css import --%>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<%--    todo: bootstrap dropdown menu --%>
<nav class="navbar navbar-expand-lg mb-4" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <%-- todo: img 기본 경로 : resources/static 임 : 절대경로로 넣을 것   --%>
            <img src="/img/simple-coding.png" width="20" height="20"/>&nbsp;
            Navbar
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%-- 부서 시작--%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Dept
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/exam01/dept">Dept(Exam01)</a></li>
                        <li><a class="dropdown-item" href="/exam02/dept">Dept(Exam02)</a></li>
                        <li><a class="dropdown-item" href="/exam03/dept">Dept(Exam03)</a></li>
                        <li><a class="dropdown-item" href="/exam04/dept">Dept(Exam04)</a></li>
                        <li><a class="dropdown-item" href="/exam05/dept">Dept(Exam05)</a></li>
                        <li><a class="dropdown-item" href="/exam06/dept">Dept(Exam06)</a></li>
                    </ul>
                </li>
                <%-- 부서 끝--%>
                <%-- 회원 시작--%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Member
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/exam01/member">Member(Exam01)</a></li>
                        <li><a class="dropdown-item" href="/exam02/member">Member(Exam02)</a></li>
                        <li><a class="dropdown-item" href="/exam03/member">Member(Exam03)</a></li>
                        <li><a class="dropdown-item" href="/exam04/member">Member(Exam04)</a></li>
                        <li><a class="dropdown-item" href="/exam05/member">Member(Exam05)</a></li>
                        <li><a class="dropdown-item" href="/exam06/member">Member(Exam06)</a></li>
                    </ul>
                </li>
                <%-- 회원 끝--%>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>