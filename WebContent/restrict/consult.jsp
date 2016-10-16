<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consult</title>
</head>
<body>
<h2> Wellcome Mr/Ms ${user.name} </h2>
<br>
${msg }
<br>
<a href="home.jsp">Home</a>
&nbsp;|&nbsp;
<a href="${request.getContextPath}/AppAccessControl/accesscontrol">Exit</a>
<hr>
<br>
<b> User logged data:</b> <br/>
Cod......: ${user.cod } <br/>
Name.....: ${user.name } <br/>
Email....: ${user.email } <br/>
Birthday.: <fmt:formatDate value="${user.birthday }" pattern="dd/MM/yyyy"/> <br/>
</body>
</html>