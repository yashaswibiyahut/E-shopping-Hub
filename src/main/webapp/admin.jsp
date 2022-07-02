<%@page import="shopping.bean.categorybean"%>
<%@page import="java.util.List"%>
<%@page import="shopping.configdao.categorydao"%>
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
        }
        
        .card:hover{
        background: #e2e2e2;
        cursor: pointer;
        }
        </style>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<%@ include file="headerAdmin1.jsp" %>  
</head>
<body background="bg.jpg" style="background-size: 100% 100vh;background-repeat: no-repeat;"align="center">

<div class="container">
<div class="container-fluid mt-3" style="color: green;">
<%
if(request.getAttribute("Catmessage")!=null)
	{
	out.println("Category Added");
	}
else if(request.getAttribute("Caterrormessage")!=null)
{
	out.println("Sorry! Category Not Added");
}
else if(request.getAttribute("Promessage")!=null)
{
	out.println("Product Added");
}
else if(request.getAttribute("Proerrormessage")!=null)
{
	out.println("Sorry! Product Not Added");
}
%>
</div>
<div class="row mt-3">
<div class="col-md-4">
<div class="card text-center">
<div class="card-body">
<div class="container">
<img style="max-width:105px;" class="img-fluid" class="rounded-circle" src="user.png" alt="">
</div>
<h1 class="text-uppercase text-muted">Users</h1>
<h1>550</h1>
</div>
</div>
</div>

<div class="col-md-4">
<div class="card text-center">
<div class="card-body">
<div class="container">
<img style="max-width:105px;" class="img-fluid" class="rounded-circle" src="list.png" alt="">
</div>
<h1 class="text-uppercase text-muted">Category</h1>
<h1>550</h1>
</div>
</div>
</div>

<div class="col-md-4">
<div class="card text-center">
<div class="card-body">
<div class="container">
<img style="max-width:160px;" class="img-fluid" class="rounded-circle" src="shopping.jpg" alt="">
</div>
<h1 class="text-uppercase text-muted">Products</h1>
<h1>550</h1>
</div>
</div>
</div>
</div>

<div class="row mt-3">
<div class="col-md-6">
<div class="card" data-toggle="modal" data-target="#add-category-modal">
<div class="card-body text-center">
<div class="container">
<img style="max-width:180px;" class="img-fluid" class="rounded-circle" src="category.png" alt="">
</div>
<h1 class="text-uppercase text-muted">Add Category</h1>
</div>
</div>


</div>
<div class="col-md-6">
<div class="card" data-toggle="modal" data-target="#add-product-modal">
<div class="card-body text-center">
<div class="container">
<img style="max-width:100px;" class="img-fluid" class="rounded-circle" src="plus.png" alt="">
</div>
<h1 class="text-uppercase text-muted">Add Product</h1>
</div>
</div>
</div>
</div>
</div>

<div class="footer">
    <jsp:include page="footer.jsp"/>
</div>
    
    
   <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="add-category-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Fill category details.</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="productservlet" method="post">
        
        <input type="hidden" name="operation" value="addcategory">
        <div class="form-group">
        <input type="text" class="form-control" name="categorytitle" placeholder="Enter Category Please" required/>
        </div>
        
        <div class="form-group">
        <textarea style="height:200px" type="text" class="form-control" name="categorydis" placeholder="Enter Discription" required></textarea>
        </div> 
        
        <div class="container text-center">
        <button class="btn btn-outline-success">Add Category</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
        </form>
      </div>

    </div>
  </div>
</div>


<div class="modal fade" id="add-product-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Fill Product details.</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="productservlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="operation" value="addproduct">
        <div class="form-group">
        <input type="text" class="form-control" name="proname" placeholder="Enter Product Name" required/>
        </div>
        
        <div class="form-group">
        <textarea style="height:80px" type="text" class="form-control" name="prodesc" placeholder="Enter Product Description" required></textarea>
        </div>
        
        <div class="form-group">
        <input type="number" class="form-control" name="proprice" placeholder="Enter Product Price" required/>
        </div>

        
        <div class="form-group">
        <input type="number" class="form-control" name="proquantity" placeholder="Enter Product Quantity" required/>
        </div>
       
        <%
        categorydao catdao = new categorydao();
        List<categorybean> cat=catdao.getcatageory();
        %>
        
        <div class="form-group">
        <select name="cattitle" id="" class="form-control" >
        
        <%
        for(categorybean s:cat){
        %>
        <option value="<%=s.getCtitle() %>" ><%=s.getCtitle() %></option>
		    <%}%>
        </select>
        </div> 
        
        <div class="form-group">
        <label for="ppic">Select Image</label><br>
        <input type="file" id="ppic" name="ppic" required />
        </div>
        
        <div class="container text-center">
        <button class="btn btn-outline-success">Add Product</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
        </form>
      </div>

    </div>
  </div>
</div>
<!-- Modal -->
</body>
</html>