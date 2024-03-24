<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Book</title>


</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("email")==null){
        response.sendRedirect("login.jsp");
    }
%>

<h2>Add New Book</h2>
<form action="AddBookServlet" method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" required><br>

    <label for="author">Author:</label><br>
    <input type="text" id="author" name="author" required><br>

    <label for="publisher">Publisher:</label><br>
    <input type="text" id="publisher" name="publisher" required><br>

    <label for="publicationDate">Publication Date:</label><br>
    <input type="date" id="publicationDate" name="publicationDate" required><br>

    <label for="subject">Subject:</label><br>
    <input type="text" id="subject" name="subject" required><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
