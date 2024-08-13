<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Welcome</p>
	<c:forEach items="${list}" var="emp">
		${emp.empId }&nbsp;	${emp.empName }&nbsp; ${emp.empSal }
	</c:forEach>
</body>
</html>