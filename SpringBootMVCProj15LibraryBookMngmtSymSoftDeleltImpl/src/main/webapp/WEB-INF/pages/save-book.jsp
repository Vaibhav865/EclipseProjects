<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Save book page </h1>
	
	<form action="/books/save" method="post">

Title:
<input type="text" name="title"/><br/>

Author:
<input type="text" name="author"/><br/>

Category:
<input type="text" name="category"/><br/>

Price:
<input type="number" step="0.01" name="price"/><br/>

Available:
<input type="checkbox" name="available"/><br/>

<button type="submit">Save</button>

</form>
	
	
</body>
</html>