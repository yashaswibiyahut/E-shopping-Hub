<%@page import="shopping.bean.categorybean"%>
<%@page import="java.util.List"%>
<%@page import="shopping.configdao.categorydao"%>
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
<title>Category</title>
<%@ include file="headerAdmin.jsp" %> 
</head>
<body background="bg.jpg" style="background-size: 100% 100vh;background-repeat: no-repeat; align="center"">
<div class="row mt-3 mx-2">
<%
categorydao catdao = new categorydao();
List<categorybean> cat=catdao.getcatageory();
%>
<div class="col-md-10">
<div class="list-group mt-4">
 <a href="#" class="list-group-item list-group-item-action active">
    Categories
  </a>
  
<%
for(categorybean str: cat)
{%>
	<a href="home.jsp" class="list-group-item list-group-item-action"><%=str.getCtitle() %></a>
<%}
%>
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
<div class="footer">
    <jsp:include page="footer.jsp"/></div>
</body>
</body>
</html>