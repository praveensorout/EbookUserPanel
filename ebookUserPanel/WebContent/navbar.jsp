<%@ page import="java.sql.*,java.util.*,bookstore.BookStore,userdata.UserData" %>
<% UserData user = (UserData)session.getAttribute("userobj");%>

<%@ include file = "links.jsp" %>
<link rel="stylesheet" href="assets/css/navbar.css">

<div class="container-fluid" style="height: 10px;background-color:#303f9f ;"></div>
<div class="container-fluid p-3 bg-light">
<div class="row">
  <div class="col-md-3 text-success">
    <h3><i class="fa-solid fa-book"></i>Ebooks</h3>
  </div>
  <div class="col-md-6">
    <form class="d-flex">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
  <div class="col-md-3">
	<% if(user==null)
  {%>
	<a href="registration.jsp" class="btn btn-primary"><i class="fas fa-user-plus"></i>Sign In</a>
	<a href="login.jsp" class="btn btn-success"><i class="fas fa-user-plus"></i>Log In</a>
  <% }else{%>
    <a href="cart.jsp" class="btn btn-warning"><i class="fa-solid fa-cart-shopping"></i>Cart</a>
	<a href="" class="btn btn-success" style="text-overflow:ellipsis;"><i class="fas fa-user-plus"></i> <%= user.getName() %></a>
	<a href="logout.jsp" class="btn btn-danger">Log Out<a>
  <%}%>
  </div>
</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="C_book.jsp"><i class="fa-solid fa-book-open"></i> C/C++ Book</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="java_book.jsp"><i class="fa-solid fa-book-open"></i> Java Book</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="python_book.jsp"><i class="fa-solid fa-book-open"></i> Python Book</a>
        </li>
      </ul>
      <form action="contact.jsp">
        <button class="btn btn-light" type="submit"><i class="fa-solid fa-address-card"></i> Contact us</button>
      </form>
    </div>
  </div>
</nav>