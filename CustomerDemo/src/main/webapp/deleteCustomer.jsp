<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<h1>Customer Account Delete</h1>

	<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	%>

	<form action="delete" method="post">
		Customer ID<input type="text" name="cusid" value="<%= id %>"  readonly><br><br> 
		Name<input type="text" name="name" value="<%= name %>" readonly><br><br>
		Phone<input type="email" name="email" value="<%= email %>" readonly><br><br>
		Phone<input type="text" name="phone" value="<%= phone %>" readonly><br><br>
		User Name<input type="text" name="username" value="<%= username %>" readonly><br><br>
		Password<input type="text" name="password" value="<%= password %>" readonly><br><br>
		
		<input type="submit" value="Delete my account">
	</form>
</body>
</html>