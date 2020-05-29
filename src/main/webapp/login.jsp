<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<header><jsp:include page="header.jsp" />
</header>
<body>
    <div class="all-content">
        <div class="autorization center column">
            <h1 class="left right"> Autorization</h1>
            <form class="column flex jus-center" action="SignIn" method="POST">
                <input required class="left right" type="text" name="Login" placeholder="Login">
                <input required class="left right" type="password" name="Password" placeholder="Password">
                <input required class="left right" type="submit" value="Submit">
            </form>
            <c:if test="${wrongLoginOrPassword}"><p class="left right" style="color:red;">Wrong Login Or Password</p></c:if>
            <c:if test="${sucessfullRegistration}"><p class="left right" style="color:green;">Sucessfull Registration</p></c:if>
        </div>
    </div>
</body>
</html>