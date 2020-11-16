<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "SignUpServlet" method = "post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="companySignUp" >
		
		<label>Name:</label>
		<input type="text" name="name" required size="50"><br>
		
		<label>Industry:</label>
		<input type="text" name="industry" required size="50"><br>
		
		<label>email:</label>
		<input type="email" name="email" required size="50"><br>
		
		<label>password:</label>
		<input type="text" name="password" required size="50"><br>
		
		<label>phone number:</label>
		<input type="text" name="phoneNumber" required size="50"><br>
		
		<label>address:</label>
		<input type="text" name="address" required size="50"><br>
		
		<label>description:</label>
		<input type="text" name="description" required size="50"><br>
		
		<label>portfolio:</label>
		<input type="file" name="portfolio" required size="50"><br>
		
		<label>displayPicture:</label>
		<input type="file" name="displayPicture" required size="50"> <br>
		
		<label> &nbsp;</label>
		<input type="submit" value="Join Now" id="submit">
	</form>
</body>
</html>