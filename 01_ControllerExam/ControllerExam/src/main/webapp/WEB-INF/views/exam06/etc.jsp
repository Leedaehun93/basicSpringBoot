<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--TODO: c lib import --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- TODO: fn lib import --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- TODO: fmt lib import --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<div class="container">
    <%-- TODO : 1. "c" library --%>
    <%-- TODO : 1) 변수에 값을 저장 --%>
    <%-- TODO : 변수 저장소(사용범위) --%>
    <%-- TODO :  page(현재 페이지) < request < session < application(전체프로그램) --%>
    <%--  사용법 : <c:set var="변수명" value="값" /> --%>
    <%--  TODO : jstl 표현식 --%>
    <p><c:set var="num" value="10" scope="page"/></p>
    <p><c:set var="num2" value="10" scope="page"/></p>
    <p><c:set var="total" value="${num + num2}" scope="page"/></p>
    <%-- TODO :  el 표현식 --%>
    <p>${num}</p>
    <p>${num2}</p>
    <p>${total}</p>

    <%-- TODO : 2) 문자열 구분자로 전체 출력함 --%>
    <%--  사용법 : <c:forTokens items="문자열" delims="구분자" var="변수명">--%>
    <%--              실행문 --%>
    <%--          </c:forTokens> --%>
    <c:forTokens items="1/2/3" delims="/" var="number">
        <h2>토큰 : ${number}</h2>
    </c:forTokens>

    <%-- TODO : 3) try ~ catch --%>
    <%--  사용법 : <c:catch var="에러변수"> --%>
    <%--               실행문 --%>
    <%--          </c:catch> --%>
    <%--  실행문이 에러가 발생하면 에러변수에 메세지가 들어감 --%>
    <c:set var="num3" value="${10/0}"/>
    <c:catch var="err">
        <h2>${num3}</h2>
    </c:catch>
    <c:if test="${not empty err}">
        에러 메세지 : ${err.message}
    </c:if>

    <%-- TODO: 4) 페이지 강제 이동 --%>
    <%--  사용법 : <c:redirect url="이동할_url주소" /> --%>
    <%--  <c:redirect url="/exam00/hello" /> --%>


    <%-- TODO : 5) 공통 페이지 끼워 넣기 : 머리말, 꼬리말 --%>
    <%--  사용법 : <c:import url="보여줄페이지"/> --%>
    <c:import url="footer.jsp"/>

    <%-- TODO : 6) url 로페이지 이동하기 --%>
    <%--  사용법 :  <c:url value="url주소" var="변수명" /> --%>
    <%--    사용 :  <a href="${변수명}">보여지는문구</a> --%>
    <c:url value="http://www.naver.com" var="naver"/>
    <h2><a href="${naver}">네이버</a></h2>

    <%---------------------------------------------------------%>

    <%-- TODO : 2. "fn(function)" library --%>
    <c:set var="chars" value="안녕하세요 홍길동입니다. Bue"/>
    <c:set var="name" value="홍길동"/>
    <%-- TODO : fn 라이브러리 el 표현식과 함께 사용 --%>
    <%--  사용법 : ${fn:contains(chars, name)} --%>
    <%-- TODO : 1) chars 문자열에 name 값 있으면 true, 없으면 false --%>
    <h2>contains : ${fn:contains(chars, name)}</h2>

    <%-- TODO : 2) chars 문자열에 "홍길동" 값이 있는 index 번호 리턴 --%>
    <h2>indexOf : ${fn:indexOf(chars, "홍길동")}</h2>

    <%-- TODO : 3) 전체 길이를 리턴 --%>
    <h2>length : ${fn:length(chars)}</h2>

    <%-- TODO : 4) chars 문자열에서 "홍길동" -> "장길산" 변경 --%>
    <h2>replace : ${fn:replace(chars, "홍길동", "장길산")}</h2>

    <%-- TODO : 5) chars 에서 " " 로 문자열 자르기 : 리턴값 : 배열 --%>
    <h2><c:set var="sChar" value='${fn:split(chars, " ")}'/></h2>
    <h2>${sChar[0]}</h2>
    <h2>${sChar[1]}</h2>
    <h2>${sChar[2]}</h2>

    <%-- TODO : 6) chasrs 에서 0 인덱스 ~ 6-1 인덱스까지 자르기 --%>
    <h2>${fn:substring(chars, 0, 6)}</h2>

    <%--   TODO: 7) 대/소문자 바꾸기 --%>
    <h2>${fn:toLowerCase(chars)}</h2>
    <h2>${fn:toUpperCase(chars)}</h2>

    <%---------------------------------------------------------%>

    <%-- TODO : 3. "fmt(function)" library --%>
    <c:set var="numtest" value="1234567890"/>
    <%--   TODO : 1) 숫자 찍기 :  --%>
    <h2><fmt:formatNumber value="${numtest}"/></h2>
    <%--   TODO : 2) 통화 찍기 :  --%>
    <h2><fmt:formatNumber value="${numtest}" type="currency"/></h2>
    <%--   TODO : 3) 날짜 포맷 주기 :  --%>
    <%--    jsp 과거 코딩 : 스크립틀릿 -> el, jstl 사용(권고) --%>
    <%-- <%@ page import="java.util.Date" %> 임포트 발생함 --%>
    <%
        Date date = new java.util.Date();
    %>
    <%-- TODO : 화면 출력시 : <%=변수명%> %>--%>
    <h2><%=date%></h2>
    <c:set var="today" value="<%=new java.util.Date()%>"/>
    <h2><fmt:formatDate value="${today}"
                        pattern="yyyy-MM-dd hh:mm:ss"/></h2>

</div>
</body>
</html>