<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>

<body background="bg.jpg" style="background-size: 100% 100vh;background-repeat: no-repeat;"align="center">
<script>
function validate()
{
	var name=document.forms["abc"]["uname"].value;
	var contact=document.forms["abc"]["ucontact"].value;
	var email=document.forms["abc"]["uemail"].value;
	var pass=document.forms["abc"]["upass"].value;
	var agree=document.forms["abc"]["agree"].value;
	if(name==""|| name==null)
	{
	alert("Please Enter Name");
	return false;
	}
	else if(email=="" || email==null)
		{
		alert("Please Enter Email");
		return false;
		}
	else if(contact==""|| contact==null)
	{
	alert("Please Enter Contact");
	return false;
	}
	else if(pass==""|| pass==null)
		{
		alert("Please Enter Password");
		return false;
		}
	else if(agree==""|| agree==null)
	{
	alert("Please tick checkbox");
	return false;
	}
		return true;
	}
</script>
<div style="position: absolute;top: 40%;width: 450px;left: 45%;margin-top: -100px;background-color: rgba(0,0,0,0.2);margin-left: -150px;">
<h2>Hello User</h2>
<form name="abc" action="signupservlet" onsubmit="return validate()" method="post">
Enter Name : <input style="margin-left:20px;" type="text" name="uname" id="uname" placeholder="Your Name" required autofocus>
<br>
<br>
Enter Email : <input style="margin-left:20px;" type="email" name="uemail" id="uemail" placeholder="Your Email" required autofocus>
<br>
<br>
Enter Contact : <input style="margin-left:10px;" type="text" name="ucontact" id="uontact" placeholder="Contact Number" required autofocus>
<br>
<br>
Enter Password : <input type="text" name="upass" id="upass" placeholder="Your Password" required autofocus>
<br>
<br>
<input type="checkbox" name="agree" id="agree"  required autofocus/><span><span></span></span>I agree all statements in <a href="terms.jsp">Terms of service</a>
<br>
<br>
<input type="submit" value="Sign Up" >
<br>
<h5><span class='notbold'>Already have an account? </span><a href="index.jsp">Sign In</h5>
</form>
</div>


</body>
</html>