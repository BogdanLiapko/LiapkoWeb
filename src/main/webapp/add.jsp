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
            <h1 class="left right">Add Advertisment</h1>
            <form class="column flex jus-center" action="AddAdvertisment" method="POST">
                <input required class="left right" type="text" name="header" placeholder="Header">
                <textarea required class="left right" name="description" placeholder="Description"></textarea>
                <input required class="left right" type="number" step="0.05" name="price" placeholder="Price">
                <input required class="left right" type="text" name="address" placeholder="Address">
                <select required class="left right" name="categories">
                    <option value="Phone">Phone</option> 
                    <option value="Auto">Auto</option>
                    <option value="Services">Services</option>
                    <option value="Property">Property</option>
                    <option value="Book">Book</option>
                </select>
                <input required class="left right" type="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>