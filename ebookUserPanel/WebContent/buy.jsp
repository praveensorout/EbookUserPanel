<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EBook : Index</title>
	<link rel="stylesheet" href="assets/css/index.css">
	<%@ include file = "links.jsp" %>
</head>
<body style="background-color: #ebeaea;">
	<%@ include file = "navbar.jsp" %>
	<%@ page import="java.sql.*,java.util.*,bookstore.BookStore" %>
	
	<jsp:useBean id="pr" class="bookstore.DisplayBook" >
	</jsp:useBean>
	
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		BookStore bs = pr.getBookById(id);
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-6 text-center p-5 bg-white border">
				<img src="../EBookUserPanel/book/<%=bs.getFileName()%>" style="height:150px; width:150px;"><br>
				<h5>Book Name:<span class="text-primary"><%=bs.getBname()%></span> </h5>
				<h5>Author Name:<span class="text-primary"><%=bs.getBauthor()%></span> </h5>
				<h5>Category:<span class="text-primary"><%=bs.getBcategory()%></span> </h5>
				<h5>Price:<span class="text-primary"><%=bs.getBprice()%></span> </h5>
			</div>
			<div class="col-md-6 text-center p-5 bg-white border">
				<h2><%=bs.getBcategory()%> Programming</h2>
				<div class="row pt-2">
					<div class="col-md-4 text-success text-center">
						<i class="fa-solid fa-money-bill-wave fa-2x"></i>
						<p>Cash on delivery</p>
					</div>
					<div class="col-md-4 text-success text-center">
						<i class="fa-brands fa-cc-amazon-pay fa-2x"></i>
						<p>Pay Online</p>
					</div>
					<div class="col-md-4 text-success text-center">
						<i class="fa-solid fa-truck fa-2x"></i>
						<p>Free delivery</p>
					</div>
				</div>
				<div class="text-center pt-3">
					<a href="buy?bid=<%=bs.getBookId()%>&&uid=<%=user.getUserId()%>&&contact=<%=user.getPhno()%>&&email=<%=user.getEmail()%>" 
						class="btn btn-primary btn-sm ml-1">Buy Now <i class="fa-solid fa-indian-rupee-sign"></i></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>