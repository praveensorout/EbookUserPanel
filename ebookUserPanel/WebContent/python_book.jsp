<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Recent : Books</title>
		<link rel="stylesheet" href="assets/css/index.css">
		<%@ include file = "links.jsp" %>
	</head>
	<%@ page import="java.sql.*,java.util.*,bookstore.BookStore" %>
	
	<style>
    .back-img{
        background-image: url(assets/images/bgimg1.jpg);
        width: 100%;
        height: 11vh;
        background-repeat: no-repeat;
        background-size: cover;
    }
    
</style>
	
	<jsp:useBean id="pr" class="bookstore.DisplayBook" >
	</jsp:useBean>
	
	<body style="background-color: #ebeaea;">
		<%@ include file = "navbar.jsp" %>
		<div class="container-fluid back-img">
        <h2 class="text-center text-white pt-3">All Python Books</h2>
		<div class="container mt-3">
        <div class="row">
		<%
			Map<Integer,BookStore> map	= pr.AllPythonBook();
			for(Integer i : map.keySet())
			{
				BookStore bs = map.get(i);
		%>	
			<div class="col-md-3">
					<div class="card">
						<div class="card-body">
								<img src="book/<%=bs.getFileName() %>" alt="" style="width: 200px;height: 200px;" class="img-thumblin">
								<p style="font-size:18px;font-weight:bold;"> <%= bs.getBname() %></p>
								<p><%=bs.getBauthor() %></p>
								<p>Categories:<%=bs.getBcategory() %></p>
								<div class="row">
									<%
									if(user==null)
									{%>
										<a href="login.jsp" class="btn btn-danger btn-sm ml-2">AddCart</a>
									<%}else{%>
										<a href="cart?bid=<%=bs.getBookId()%>&&uid=<%=user.getUserId()%>" class="btn btn-danger btn-sm ml-2">AddCart</a>
									<%}%>
										<a href="book_details.jsp?id=<%=bs.getBookId() %>" class="btn btn-success btn-sm ml-1">ViewDetail</a>
									<%
										if(user==null)
									{%>
										<a href="login.jsp" class="btn btn-danger btn-sm ml-2">BuyNow</a>
									<%}else{%>
										<a href="buy.jsp?id=<%=bs.getBookId()%>" class="btn btn-danger btn-sm ml-2">BuyNow</a>
									<%}%>
								</div>
						</div>
					</div>
				</div>
		<%
			}
		%>
        </div>
    </div>
    </div>
	</body>
</html>