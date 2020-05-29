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
            <h1 class="left right">Registration</h1>
            <form class="column flex jus-center" action="SignUp" method="POST">
                <input required class="left right" type="text" name="login" placeholder="Login">
                <input required class="left right" type="password" name="password" placeholder="Password">
                <input required class="left right" type="password" name="repeatPassword" placeholder="Repeat Password">
                <input required class="left right" type="text" name="city" placeholder="City">
                <input required class="left right" type="text" name="address" placeholder="Address">
                <input required onkeyup="this.value = this.value.replace (/[^0-9+]/g, '')" maxlength="13" class="left right" type="text" name="phone" placeholder="Phone">
                <input required class="left right" type="submit" value="Submit">
            </form>
            <c:if test="${loginLenght}"><p class="left right" style="color:red;">Login Lenght</p></c:if>
            <c:if test="${passwordLenght}"><p class="left right" style="color:red;">Password Lenght</p></c:if>
            <c:if test="${phoneExist}"><p class="left right" style="color:red;">Phone Exist</p></c:if>
            <c:if test="${passwordMismatch}"><p class="left right" style="color:red;">Password Mismatch</p></c:if>
            <c:if test="${userExist}"><p class="left right" style="color:red;">User Exist</p></c:if>
        </div>
    </div>
</body>
</html>