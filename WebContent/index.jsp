<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<h2> Access Controll in JSP and Servlet with JDBC </h2>
<br>

<a href="index.jsp">Registration</a>
&nbsp;|&nbsp;
<a href="login.jsp">Login</a>
<hr>
<br>
${msg }
<br>
<form name="formreg" method="post" action="usercontrolreg">
Name:<br>
<input type="text" name="name"/> <br><br>

Birthday:<br>
<input type="text" name="birthday"/> <br><br>

E-mail<br><input type="text" name="email"/> <br><br>

Password:<br>
<input type="password" name="password"/> <br><br>

Confirm your password:<br>
<input type="password" name="confpassword"/> <br><br>

Street:<br>
<input type="text" name="street"/> <br><br>

Neighborhood:<br>
<input type="text" name="neighborhood"/> <br><br>

City:<br>
<input type="text" name="city"/> <br><br>

<br>
<input type="submit" value="Registrer" onclick="verifypassword()"/> 
&nbsp;
<input type="reset" value="Clear Data"/> <br><br>
</form>

<script type="text/javascript">
function verifypassword(){
	
	daterule = /^\d{2}\/\d{2}\/\d{4}$/;	
	
	if(formreg.password.value != formreg.confpassword.value){
		alert("Problem! The passwords are different.");
		formreg.password.value = "";
		formreg.confpassword.value = "";
		formreg.password.focus();
	}else if(!formreg.birthday.value.match(daterule)){
		alert("Problem! The date need to be DD/MM/YYYY.");
		formreg.birthday.value = "";
		formreg.birthday.focus();
	}else{
		formreg.submit();
	}
}
</script>
</body>
</html>