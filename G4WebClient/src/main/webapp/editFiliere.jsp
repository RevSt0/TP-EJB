<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>


	<form method="post" action="FiliereController?action=update">
		<table cellpadding="2" cellspacing="2">
		
		
			<tr>
				<td>ID</td>
				<td>${filiere.id }</td>
			</tr>
		
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${filiere.name }"></td>
			</tr>
			
			<tr>
				<td>Code</td>
				<td><input type="text" name="code" value="${filiere.code }"></td>
			</tr>
			
			
			

			
			
			
			
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Update"></td>
			</tr>
			
			
	
	
	
	
	</table>
	</form>
</body>
</html>