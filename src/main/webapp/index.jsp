<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<header>
<jsp:include page="header.jsp" />
</header>
<body>
    <div class="all-content">
        <div class="main bot left right">
        <div class="panel-container row">
            <c:forEach var="sAdvertisments" items="${sAdvertisments}"> 
                <div class="panel vertical">
                    <a href="/Dashboard/Show?prodId=${sAdvertisments.prodId}">${sAdvertisments.header}</a>
                </div> 
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>