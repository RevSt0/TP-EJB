<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="height:100%; display:table; margin:auto;">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="height:100%;">
	
	
	<h1><a href="FiliereController?action=add" style="text-decoration:none; color:inherit;">New Filiere</a></h1>
	<table cellpadding="5" cellspacing="5" border="6">
		<tr>
			<th>ID</th>
			<th>Code</th>
			<th>Name</th>
			<th>Options</th>
		
	   </tr>
	
	<c:forEach var="filiere" items="${listFilieres }">
		<tr>
			<td>${filiere.id}</td>
			<td>${filiere.code }</td>
			<td>${filiere.name }</td>
			<td><a href="FiliereController?action=update&id=${filiere.id}" style="text-decoration:none; color:blue;">Update</a> 
			or <a href="FiliereController?action=delete&id=${filiere.id}" onclick="return confirm('Are you sure')" style="text-decoration:none; color:red;">Delete</a></td>
			
	
		</tr>
		
	</c:forEach>
	
	
	</table>

	
</body>
</html>