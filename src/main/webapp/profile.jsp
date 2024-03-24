<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>
    <c:out value="Username: ${user.username}" /><br>
    <c:out value="Email: ${user.email}" /><br>
    <c:out value="Phone: ${user.phone}" /><br>
    <c:out value="Age: ${user.age}" /><br>
    <c:out value="Role: ${user.role}" /><br>
    <c:out value="Account: ${user.account}" /><br>
</body>
</html>
