<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About</title>
<%@ include file="headerAdmin.jsp" %> 
</head>
<body background="bg.jpg" style="background-size: 100% 100vh;background-repeat: no-repeat;">
<div style="position: absolute;top: 15%;width: 450px;">
<u><h4>ABOUT US</h4></u>
<p>
Our Website: ShoppingHub.com<br>
Address: NBCC,Newtown Kolkata 700156<br>
Contact: +91123456789<br></p>
<u><h4>Map Location</h4></u>
<p><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d29472.353736046232!2d88.42225711562502!3d22.5774495!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a02751741a06411%3A0x8fe964cdf13af21f!2sBlock%20A%2C%20NBCC%20Vibgyor%20Towers%20Gate%201!5e0!3m2!1sen!2sin!4v1652258363863!5m2!1sen!2sin" width="400" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe></p>
</div>
<div style="position: absolute;top: 15%;width: 400px; left:965px">
<u><h4 >Our Team</h4>
<div ></u>
  <div class="column">
    <div >
      <img src="my.jpeg" alt="Yashaswi" style="width:35%">
      <div class="container">
        <h2>Yashaswi Biyahut</h2>
        <p class="title">CEO & Founder<br>
        Engineer by profession.<br>
        yashaswibiyahut25@gmail.com</p>
      </div>
    </div>
  </div>
  </div>
</div>
<div style="position: absolute; margin-left: 93%; margin-top:28%; color: red">

<!--Start of Tawk.to Script-->
<script type="text/javascript">
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/627b9823b0d10b6f3e71aa12/1g2pckjeu';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script>
<!--End of Tawk.to Script-->
</div>
<div class="footer" style="position: absolute;margin-top: -100px;margin-left: -110px;" align="center">
    <jsp:include page="footer.jsp"/></div>
</body>
</html>