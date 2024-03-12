
		<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>Ebook: Login</title>
		</head>
		<%@ include file="links.jsp" %>
		<body>
			<%@ include file="navbar.jsp" %>
			<% if(user==null)
			{%>
			<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); %>
			<div class="container mt-2">
				<div class="row">
					<div class="col-md-4 offset-md-4">
						<div class="card">
							<div class="card-body">
								<form action="login" method="post">
									<div class="form-group">
										<label for="exampleInputEmail1">Email Address</label>
										<input type="text" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" required="required" name="email">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Password</label>
										<input type="password" class="form-control" id="exampleInputPassword1"
										aria-describedby="emailHelp" required="required" name="password">
									</div>
									<div class="text-center">
										<button type="submit" class="btn btn-primary">SignIn</button>
								</form>
									<a href="registration.jsp">Create Account</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</body>
	</html>
<%}
else{
	response.sendRedirect("index.jsp");
}%>