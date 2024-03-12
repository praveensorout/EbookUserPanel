<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, cartstore.CartStore, cartdata.CartDisplay, cartdata.CartSerializer" %>
<%
    CartDisplay cart = CartSerializer.deserializeCart();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
    <h1 class="text-center">Shopping Cart</h1>
			
    <table class="table table-striped">
        <thead class="bg-primary text-white">
          <tr>
			<th scope="col">Image</th>
			<th scope="col">Book Name</th>
			<th scope="col">Author</th>
            <th scope="col">Price</th>
            <th scope="col">Category</th>
			<th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
		<% if (cart != null) {
            for (CartStore cs : cart.getCartItems().values()) { %>	
			<tr><% if(user.getUserId()==cs.getUserId())
			{%>
				<td><img src="book/<%=cs.getFileName() %>" alt="" style="width: 50px;height: 50px;" class="img-thumblin"></td>
				<td> <%= cs.getBname() %> </td>
				<td> <%=cs.getBauthor() %></td>
				<td> <%=cs.getBprice() %></td>
				<td> <%=cs.getBcategory() %></td>
				<td><a href="deletecart?bid=<%= cs.getBookId()%>" class="btn btn-sm btn-danger">Delete</a></td>
			</tr>
		<%  } %>
		<%  }
        } else { %>
            <tr><td colspan="5">Cart is empty</td></tr>
        <% } %>
        </tbody>
      </table>

</body>
</html>
