<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data</title>
</head>
<body>

	<c:forEach var="cus" items="${cusDetails}">
	
		<c:set var="id" value="${cus.id}"/>
		<c:set var="name" value="${cus.name}"/>
		<c:set var="email" value="${cus.email}"/>
		<c:set var="phone" value="${cus.phone}"/>
		<c:set var="username" value="${cus.userName}"/>
		<c:set var="password" value="${cus.password}"/>
	
	
		<table>
			<tr>
				<th>ID</th>
				<td>${cus.id}</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>${cus.name}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${cus.email}</td>
			</tr>
			<tr>
				<th>Phone</th>
				<td>${cus.phone}</td>
			</tr>
			<tr>
				<th>User Name</th>
				<td>${cus.userName}</td>
			</tr>
			<tr>
				<th>Password</th>
				<td>${cus.password}</td>
			</tr>
		</table>

	</c:forEach>
	
	<br><br>
	
	<c:url value="updateCustomer.jsp" var="cusUpdate">
	
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone" value="${phone}"/>
		<c:param name="username" value="${username}"/>
		<c:param name="password" value="${password}"/>
		
	</c:url>
	
	<a href="${cusUpdate}">
		<input type="button" name="update" value="Update account">
	</a>
	
	<br><br>
	
	<c:url value="deleteCustomer.jsp" var="cusDelete">
		<c:param name="id" value="${id }" />
		<c:param name="name" value="${name }" />
		<c:param name="email" value="${email }" />
		<c:param name="phone" value="${phone }" />
		<c:param name="username" value="${username }" />
		<c:param name="password" value="${password }" />
	</c:url>
	<a href="${cusDelete }">
	<input type="button" name="delete" value="Delete account">
	</a>

</body>
</html>