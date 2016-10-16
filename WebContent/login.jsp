<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<h2> Access Controll in JSP and Servlet with JDBC </h2>
<br>
${msg}
<br>
<a href="index.jsp">Registration</a>
&nbsp;|&nbsp;
<a href="login.jsp">Login</a>
<hr>
<br>

<form name="formreg" method="post" action="accesscontrol">

Email:<br>
<input type="text" name="email"/> <br><br>

Password:<br>
<input type="password" name="password"/> <br><br>

<input type="submit" value="Registrer"/>

</form>
<br><br>
<form method="post" action="newpassword">
Inform email and request the new password
<br><br><br>
<input type="text" name="email"/> <br><br>

<br>
<input type="submit" value="New Password"/> 
&nbsp;

</form>

</body>
</html>