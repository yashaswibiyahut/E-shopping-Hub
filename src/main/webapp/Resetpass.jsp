
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset page</title>
</head>
<body background="bg.jpg"
	style="background-size: 100% 100vh; background-repeat: no-repeat;"
	align="center">
	<script>
		/*function validate()
		 {
		 var contact=document.forms["abc"]["ucontact"].value;
		 //var pass=document.forms["abc"]["upass"].value;
		 //var cpass=document.forms["abc"]["ucpass"].value;
		 if(contact=="" || contact==null)
		 {
		 alert("Please Enter Contact Number");
		 return false;
		 }
		 else if(pass==""|| pass==null)
		 {
		 alert("Please Enter Password");
		 return false;
		 }
		 else if(cpass==""|| cpass==null)
		 {
		 alert("Please Enter Password"); 
		 return false;
		 }
		 return true;
		 }*/
	</script>
	<div
		style="position: absolute; top: 40%; width: 450px; left: 45%; margin-top: -100px; background-color: rgba(0, 0, 0, 0.2); margin-left: -150px;">
		<div style="color: red;">
			<%--
<% 
if(((Boolean)request.getAttribute("errormessage")))
{
	%>
	<script>
	error.message("Invalid Email/Password")
	//alert("Wrong credentials. Please try again !!");
	window.location="index.jsp";
	
	</script>		
	<%
}

	%>
	 --%>
		</div>
		<h2>Forgot Password? We are here!!!</h2>

		<form name="abc" action="generateOTPservlet" method="post">
			<%
				if (request.getAttribute("email") != null) {
			%>
			Enter Email : <input type="email" name="uemail"
				style="margin-left: 20px;" id="uemail" placeholder="Your Email"
				value="<%=request.getAttribute("email")%>" required autofocus ><br>
			<input type="submit" style="margin-left: 33px;" value="Generate OTP">
			<%
				} else {
			%>
			Enter Email : <input type="email" name="uemail"
				style="margin-left: 20px;" id="uemail" placeholder="Your Email"
				required autofocus><br>
			<input type="submit" style="margin-left: 33px;" value="Generate OTP">
			<%
				}
			%>
			<div style="color: red;">
				<%
					if (request.getAttribute("message") != null) {
						out.println("OTP sent successfull!");
					} else if (request.getAttribute("errorusermessage") != null) {
						out.println("Incorrect Email!");
					}
				%>

			</div>
		</form>
		<br>
		<form name="abc" action="verifyotp" method="post">
			<input type="hidden" name="votp"
				value="<%=request.getAttribute("verifyotp")%>">
			<%
				if (request.getAttribute("message") != null) {
			%>
			Enter OTP : <input style="margin-left: 28px;" type="text" name="uotp"
				id="uotp" placeholder="OTP" required autofocus><br>
			<%
				if (request.getAttribute("errormessage") != null) {
						out.println("Incorrect OTP! Please try again.");
					}
			%>
			<input type="submit" value="Reset Password"
				style="margin-left: 50px;">
			<%
				}
			%>
			<br>
			<h5>
				<span class='notbold'>Can`t login? </span><a href="Signup.jsp">Register
					Now!
			</h5>
		</form>
	</div>
</body>
</html>