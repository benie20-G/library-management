<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Books</title>
</head>
<body>
<h2>Books Information</h2>
<table border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Publication Date</th>
        <th>Subject</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="books" scope="request" type="java.util.List"/>
    <c:forEach items="${books}" var="book" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.publicationDate}</td>
            <td>${book.subject}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
