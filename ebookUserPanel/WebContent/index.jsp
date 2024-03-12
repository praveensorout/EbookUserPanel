<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EBook : Index</title>
	<link rel="stylesheet" href="assets/css/index.css">
	<%@ include file = "links.jsp" %>
</head>

<style>
    .back-img{
        background-image: url(assets/images/bgimg1.jpg);
        width: 100%;
        height: 50vh;
        background-repeat: no-repeat;
        background-size: cover;
    }
    
</style>
	
	<jsp:useBean id="pr" class="bookstore.DisplayBook" >
	</jsp:useBean>
	
<body style="background-color: #ebeaea;">
    <%@ include file = "navbar.jsp" %>
    <div class="container-fluid back-img">
        <h2 class="text-center text-white pt-3">Ebook Management System</h2>
    </div>
	
	<% if(request.getAttribute("msg")!=null)
		{%>
			<h3 style="color:red;" class="text-center"><%= request.getAttribute("msg") %> </h3>
		<%}%>
    <!-- start of C/C++ books -->
    <hr>
    <div class="container mt-3">
        <h3 class="text-center ">C/C++ Books</h3>
        <div class="row">
		
		<%
			Map<Integer,BookStore> map	= pr.displayCBook();
			for(Integer i : map.keySet())
			{
				BookStore bs = map.get(i);
		%>	
			<div class="col-md-3">
					<div class="card">
						<div class="card-body text-center">
								<img src="book/<%=bs.getFileName() %>" alt="" style="width: 200px;height: 200px;" class="img-thumblin">
								<p style="font-size:18px;font-weight:bold;"> <%= bs.getBname() %></p>
								<p><%=bs.getBauthor() %></p>
								<p>Categories:<%=bs.getBcategory() %></p>
								<p>Price:<%=bs.getBprice() %> <i class="fa-solid fa-indian-rupee-sign"></i></p>
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
        <div class="text-center mt-1">
            <a href="C_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
        </div>
    </div>
    <!-- end of C/C++ books -->
<hr>
    <!-- start of java books -->
    <div class="container mt-3">
        <h3 class="text-center">Java Books</h3>
        <div class="row">
            <%
					Map<Integer,BookStore> map1 = pr.displayJavaBook();
					for(Integer i : map1.keySet())
					{
						BookStore bs = map1.get(i);
				%>
				<div class="col-md-3">
					<div class="card">
						<div class="card-body">
								<img src="book/<%=bs.getFileName() %>" alt="" style="width: 200px;height: 200px;" class="img-thumblin">
								<p style="font-size:18px;font-weight:bold;"> <%= bs.getBname() %></p>
								<p><%=bs.getBauthor() %></p>
								<p>Categories:<%=bs.getBcategory() %></p>
								<p>Price:<%=bs.getBprice() %> <i class="fa-solid fa-indian-rupee-sign"></i></p>
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
        <div class="text-center mt-1">
            <a href="java_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
        </div>
    </div>
    <!-- end of java books -->
    <hr>
    <!-- start of python books -->
    <div class="container mt-3">
        <h3 class="text-center">Phython Books</h3>
        <div class="row">
            <%
					Map<Integer,BookStore> map2 = pr.displayPythonBook();
				%>
				<%
					for(Integer i : map2.keySet())
				{
					BookStore bs = map2.get(i);
				%>
				<div class="col-md-3">
					<div class="card">
						<div class="card-body">
								<img src="book/<%=bs.getFileName() %>" alt="" style="width: 200px;height: 200px;" class="img-thumblin">
								<p style="font-size:18px;font-weight:bold;"> <%= bs.getBname() %></p>
								<p>Author:<%=bs.getBauthor() %></p>
								<p>Categories:<%=bs.getBcategory() %></p>
								<p>Price:<%=bs.getBprice() %> <i class="fa-solid fa-indian-rupee-sign"></i></p>
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
        <div class="text-center mt-1">
            <a href="python_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
        </div>
    </div>
    <!-- end of python books -->
    <%@ include file="footer.jsp" %>
</body>
</html>