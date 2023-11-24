<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


			<form method="post" action="FiliereController?action=add">
		<table cellpadding="5" cellspacing="5">
		
		
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			
			<tr>
				<td>Code</td>
				<td><input type="text" name="code"></td>
			</tr>


			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save"></td>
			</tr>
			</table>
			</form>
	
	</body>
</html>