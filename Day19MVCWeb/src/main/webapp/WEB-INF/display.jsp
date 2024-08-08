<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>
	<h1>Employee Details</h1>
	<c:choose>
    	<c:when test="${action == 'All'}">
         	<table>
         		<tr>
	          		<th>Id</th>
    	      		<th>Name</th>
        	  		<th>Salary</th>
         		</tr>
        		<c:forEach var="item" items="${list}">
					<tr>
						<td>${item.empId}</td>
						<td>${item.empName}</td>
						<td>${item.empSal}</td>
					</tr>    
	        	</c:forEach>
        	</table>
		</c:when>
    	<c:otherwise>
        	<td>Id: ${item.empId}</td>
			<td>Name: ${item.empName}</td>
			<td>Salary: ${item.empSal}</td>
    	</c:otherwise>
	</c:choose>
	
	<br><br>
	<form action="<c:url value='/home'/>" method="get">
		<input type="submit" value="Go Home">
	</form>
</body>
</html>