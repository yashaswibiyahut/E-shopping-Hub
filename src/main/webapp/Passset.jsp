<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg.jpg" style="background-size: 100% 100vh;background-repeat: no-repeat;"align="center">
<script>
function validate()
{
	var email=document.forms["abc"]["email"].value;
	var pass=document.forms["abc"]["newpass"].value;
	var npass=document.forms["abc"]["newcpass"].value;
	if(email=="" || email==null)
		{
		alert("Please Enter Email id");
		return false;
		}
	else if(pass=="" || pass==null)
	{
	alert("Please Enter Password");
	return false;
	}
	else if(npass==""|| npass==null)
		{
		alert("Please Confirm Password");
		return false;
		}
		return true;
	}
</script>
<div style="position: absolute;top: 40%;width: 450px;left: 45%;margin-top: -100px;background-color: rgba(0,0,0,0.2);margin-left: -150px;">
<div style="color: red;">
</div>
<h2>Dont worry! We are here for you.</h2>
<form name="abc" action="setpassservlet" onsubmit="return validate()" method="post">
Enter Email : <input style="margin-left:20px;" type="email" name="email" id="email" required autofocus>
<br>
<br>
New Password : <input style="margin-left:20px;" type="text" name="newpass" id="newpass" placeholder="Password" required autofocus>
<br>
<br>
Confirm Password : <input type="text" name="newcpass" id="newcpass" placeholder="New Password" required autofocus>
<br>
<div style="color: red;">
<%
if(request.getAttribute("errormessage")!=null)
{
out.println("Password missmatch!");
}
else if(request.getAttribute("message")!=null)
{%>
	<script>
	//error.message("Password Reset Successfull!"));
	alert("Password Reset Successfull! !!");
	window.location="index.jsp";
	
	</script>
<%}%>
</div>
<br>
<br>
<input type="submit" value="Reset" >
<br>
</form>

</div>
</body>
</html>