<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="header row">
    <div class="left half vertical flex">
        <a href="/Dashboard/">Find All</a>
    </div>
    <div class="right half vertical flex">
        <div class="dropdown">
            <button class="mainmenubtn">Categories</button>
            <div class="dropdown-child">
              <a href="/Dashboard/Filter?category=Phone">Phone</a>
              <a href="/Dashboard/Filter?category=Auto">Auto</a>
              <a href="/Dashboard/Filter?category=Services">Services</a>
              <a href="/Dashboard/Filter?category=Property">Property</a>
              <a href="/Dashboard/Filter?category=Book">Book</a>
            </div>
          </div>
          <c:if test="${sessionScope.sessionLogin==null}">
        <a href="/Dashboard/register.jsp">Registration</a>
        <a href="/Dashboard/login.jsp">Sign In</a>
        </c:if>
        <c:if test="${sessionScope.sessionLogin!=null}">
        <a href="/Dashboard/add.jsp">Add Advertisment</a>  
        <a href="">${sessionScope.sessionLogin}</a>
        <a href="/Dashboard/LogOut">Log Out</a>
        </c:if>
    </div>
</div>