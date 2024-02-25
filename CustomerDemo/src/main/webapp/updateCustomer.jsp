<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	%>
	
	<form action="update" method="post">
		Customer ID<input type="text" name="cusid" value="<%= id %>"  readonly><br><br> 
		Name<input type="text" name="name" value="<%= name %>"><br><br>
		Phone<input type="email" name="email" value="<%= email %>"><br><br>
		Phone<input type="text" name="phone" value="<%= phone %>"><br><br>
		User Name<input type="text" name="username" value="<%= username %>"><br><br>
		Password<input type="text" name="password" value="<%= password %>"><br><br>
		
		<input type="submit" value="Update">
	</form>
</body>
</html>