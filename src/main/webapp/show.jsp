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
        <div class="main bot left right column">
            <c:forEach var="sAdvertisments" items="${sAdvertisments}">
                <h1>${sAdvertisments.header}</h1>
                <c:if test="${!isEdit}">
                    <h2>${sAdvertisments.description}</h2>
                    <h2>${sAdvertisments.price} uah</h2>
                    <h2>${sAdvertisments.address}</h2>
                </c:if>
                <c:if test="${isEdit}">
                    <textarea form="AdverstimentInfo" name="description" cols="30" rows="10" required placeholder="Description">${sAdvertisments.description}</textarea>
                    <input form="AdverstimentInfo" type="number" step="0.05" name="price" required placeholder="Price" value="${sAdvertisments.price}">
                    <input form="AdverstimentInfo" type="text" name="address" required placeholder="Adress" value="${sAdvertisments.address}">
                </c:if>
                <h2>${sAdvertisments.categorie}</h2>
                <form method="POST" id="AdverstimentInfo">
                    <input type="hidden" name="prodId" value="${sAdvertisments.prodId}">
                    <c:if test="${(permission == 1) or (userId.equals(advUserId))}">
                        <c:if test="${!isEdit}"><input type="submit" value="Edit" formaction="Edit" formmethod="GET"></c:if><c:if test="${isEdit}"><input type="submit" value="Confirm" formaction="EditAdvertisment"></c:if>
                        <c:if test="${!isEdit}"><input type="submit" value="Delete" formaction="Delete"></c:if>
                    </c:if>
                </form>
            <c:if test="${sessionScope.sessionLogin != null}">
                <form class="column" id="AddComment" action="AddComment" method="post">
                    <input type="hidden" name="prodId" value="${sAdvertisments.prodId}">
                    <textarea required cols="30" rows="5" name="comment" maxlength="1999"
                        placeholder="Comment"></textarea>
                    <input type="submit" class="left" value="Submit">
                </form>
            </c:if>
        </c:forEach>
            <c:forEach var="commUsers" items="${commUsers}">
                <div class="comm column">
                    <h1>${commUsers.userName}</h1>
                    <h2>${commUsers.comm}</h2>
                </div>
            </c:forEach>
        </div>
    </div>
    </div>
</body>

</html>