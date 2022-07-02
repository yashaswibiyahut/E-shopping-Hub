<%@page import="shopping.bean.loginbean"%>
<html>
<body background="bg.jpg" style="background-size: cover;background-repeat: no-repeat;background-position: bottom;" align="center">
<script>
function validate()
{
	var email=document.forms["abc"]["uemail"].value;
	var pass=document.forms["abc"]["upass"].value;
	if(email=="" || email==null)
		{
		alert("Please Enter Email");
		return false;
		}
	else if(pass==""|| pass==null)
		{
		alert("Please Enter Password");
		return false;
		}
		return true;
	}
</script>

<div style="position: absolute;top: 40%;width: 450px;left: 45%;margin-top: -100px;background-color: rgba(0,0,0,0.2);margin-left: -150px;">
<div style="color: red;">
<%
	if(request.getAttribute("errormessage")!=null)
	{
	out.println("Invalid Email/Password");
	}

%>
</div>
<h2>Welcome to ShoppingHub !</h2>
<form name="abc" action="login" onsubmit="return validate()" method="post">
Enter Email : <input style="margin-left:20px;" type="email" name="uemail" id="uemail" placeholder="Your Name" required autofocus>
<br>
<br>
Enter Password : <input type="password" name="upass" id="upass" placeholder="Your Password" required autofocus>
<br>
<br>
<input type="submit" value="Submit" >
<br>
<h5><span class='notbold'>Can`t login? </span><a href="Signup.jsp">Register Now!</h5>
<h5><a href="Resetpass.jsp">Forgot Password?</h5>
</form>
</div>
</body>
</html>
