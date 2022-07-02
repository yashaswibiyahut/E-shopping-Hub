<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<style type="text/css">

    .footer{
       
        bottom: 0;
        height: 56px;
        left: 0;
        position: absolute;
        right: 0;
        </style>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<%@ include file="headerAdmin.jsp" %>  
</head>
<body background="bg.jpg" style="background-size: 100% 100vh;background-repeat: no-repeat;"align="center">
<div style="position: absolute;top: 40%;width: 450px;left: 50%;margin-top: -100px;margin-left: -150px;">
<h4>Your cart is empty!</h4>
</div>

<div class="footer">
    <jsp:include page="footer.jsp"/></div>
</body>
</html>