<%@page import="shopping.bean.categorybean"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shopping.bean.helper"%>
<%@page import="shopping.configdao.categorydao"%>
<%@page import="java.util.List"%>
<%@page import="shopping.bean.productbean"%>
<%@page import="shopping.configdao.productDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style type="text/css">
.list-group-item.active {
	background: #673ab7 !important;
}

.footer {
	bottom: 0;
	height: 56px;
	left: 0;
	right: 0;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">



<%@ include file="headerAdmin1.jsp"%>
</head>
<body background="bg.jpg"
	style="background-size: 100% 100vh; background-repeat: no-repeat;"
	align="center">

	<div class="row mt-3 mx-2" style="overflow-y:scroll; max-height:79.3vh;">
		<%
		    List<productbean> list=null;
		    
				String category=request.getParameter("category");
			
		System.out.println("category id="+request.getParameter("category"));
			productDao pdao = new productDao();
			{
				if(category.trim().equals("all"))
				{
					list = pdao.getallproducts();
				}
				else
				{
					int cid=Integer.parseInt(category.trim());
					list=pdao.getallproductsbyId(cid);
				}
			}
			
		
			categorydao catdao = new categorydao();
			List<categorybean> cat = catdao.getcatageory();
		%>
		<div class="col-md-2">
			<div class="list-group mt-4">
				<a href="homeAdmin.jsp?category=all" class="list-group-item list-group-item-action active">
					All Categories </a>

				<%
					for (categorybean s : cat) {
						System.out.println(s.getCtitle());
						System.out.println(s.getId());
				%>
				<a href="homeAdmin.jsp?category=<%=s.getId() %>"
					class="list-group-item list-group-item-action"><%=s.getCtitle() %></a>
				<%
					}
				%>
			</div>
		</div>
		<div class="col-md-10">
			<div class="row mt-4">
				<div class="col-md-12">
					<div class="card-columns">
						<%
							for (productbean pbean : list) {
								System.out.println(pbean.getProname());
						%>
						<div class="card">
						 <%-- <img class="card-img-top" src="D:\\Workkspace\\shopping\\img\\Products\\<%=pbean. %>" alt="Card image cap"> --%>
						<div class="container text-center">
						<img alt="" src="./image?filename=<%=pbean.getPphoto()%>" style="max-height:200px; max-width=100%; width:auto; ">
						</div>
						
							<div class="card-body">
								<h5 class="card-title"><%=pbean.getProname()%></h5>
								<p class="card-text"><%=helper.get10words(pbean.getProname())%>
							</div>
							<div class="card-footer">
								<button class="btn text-white"
									style="background-color: #673ab7 !important;">Add to
									cart</button>
								<button class="btn btn-outline-primary">
									&#8377;<%=pbean.getProprice()%></button>
							</div>
						</div>
						<%
							}
						%>
					</div>
				</div>

			</div>

		</div>


	</div>





	<div class="footer">
		<jsp:include page="footer.jsp" /></div>
</body>
</html>