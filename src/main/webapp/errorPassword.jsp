<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding-top: 50px;
        }
        .title{
            text-align: center;
        }

        h1 {
            color: #FF0000;
            text-align: center;
        }

        p {
            color: #666;
            font-size: 18px;
            margin: auto;

        }
        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h1>ooops!!!</h1>
<p class="title">your password must be strong enough</p>

    <p>At least one digit.</p>
    <p>At least one lowercase letter.</p>
    <p>At least one uppercase letter.</p>
    <p>At least one special character.</p>
    <p>No whitespace allowed in the entire string.</p>
    <p>Minimum length of 8 characters.</p>


<a href="registration.jsp">Back</a>
</body>
</html>
