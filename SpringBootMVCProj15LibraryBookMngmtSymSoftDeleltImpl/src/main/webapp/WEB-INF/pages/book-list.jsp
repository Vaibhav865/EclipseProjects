<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<h1> Add Boook</h1>
		
		

<h2>Book List</h2>

<a href="/books/add">Add Book</a>
<a href="/books/trash">Trash</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Category</th>
        <th>Price</th>
        <th>Available</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${books}" var="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.title}</td>
            <td>${b.author}</td>
            <td>${b.category}</td>
            <td>${b.price}</td>
            <td>${b.available}</td>
            <td>
                <a href="/books/edit/${b.id}">Edit</a>
                <a href="/books/delete/${b.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
		
		
	
</body>
</html>