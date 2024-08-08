<%@ page language="java" pageEncoding="UTF-8"%>
<%
    // Forward request to login.jsp located in WEB-INF
    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
%>

<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
