<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <%
String username = request.getParameter("username");
%>
   
    <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Library Dashboard</title>



<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-bottom: 20px;
    border-bottom: 1px solid #ddd;
}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

nav ul li {
    display: inline-block;
    margin-right: 20px;
}

nav ul li a {
    text-decoration: none;
    color: #333;
    font-weight: bold;
}

main {
    padding: 20px 0;
}

section {
    margin-bottom: 20px;
}

.welcome {
    text-align: center;
}

.books {
    text-align: center;
}

.book-list {
    display: flex;
    justify-content: center;
    gap: 20px;
    padding:20px;
    margin:20px;
}

.book img {
    max-width: 100%;
    height: auto;
    padding:20px;
border-radius:10px;
     transform: translateZ(0);
      -moz-transform: translateZ(0);
      -webkit-transform: translateZ(0);
      -o-transform: translateZ(0);
      -ms-transform: translateZ(0);
      -webkit-transition-duration: 0.3s;
      transition-duration: 0.3s;
      -webkit-transition-property: transform;
      transition-property: transform;
      -webkit-transition-timing-function: ease-out;
      transition-timing-function: ease-out; }
  .book img:hover  {
    -webkit-transform: scale(1.3) translateZ(0);
    transform: scale(1.3) translateZ(0); 
    cursor:pointer;
    padding:40px
}

footer {
    text-align: center;
    margin-top: 20px;
    padding-top: 20px;
    border-top: 1px solid #ddd;
}
</style>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}
%>
<div class="container">
    <header>
        <h1>Dashboard📚</h1>
        <nav>
            <ul>
                <li><input type="text" name="title" placeholder="Search"></li>
                <li><a href="DisplayBooksServlet">View Books</a></li>
                <li><a href="ViewServlet">Profile</a></li>
                <li><a href="addBook.jsp">Add Book</a></li>
                <li><a href="LogoutServlet">Logout</a></li>

            </ul>
        </nav>
    </header>
    <main>
        <section class="welcome">
           Welcome, <%= session.getAttribute("username") %>!
    <p>Explore our collection of novels and manage your profile.</p>
        </section>
        <section class="books">
            <h2>Borrowed Novels</h2>
            <div class="book-list">
                             <div class="book">
                    <img src="style/images/novel.jpg" width="200px" height="200px" alt="Book 2">
                    <p>Good Amish medicine</p>
                </div>
                <div class="book">
                    <img src="style/images/edf.jpg" width="200px" height="200px" alt="Book 3">
                    <p>Ghost in machine</p>
                </div>
                 
                <div class="book">
                    <img src="style/images/this.jpg" width="200px" height="200px" alt="Book 1">
                    <p>Revenge of the ghost</p>
                </div>
                <div class="book">
                    <img src="style/images/novel.jpg" width="200px" height="200px" alt="Book 2">
                    <p>Good Amish medicine</p>
                </div>
                <div class="book">
                    <img src="style/images/edf.jpg" width="200px" height="200px" alt="Book 3">
                    <p>Ghost in machine</p>
                </div>
                <div class="book">
                    <img src="style/images/edf.jpg" width="200px" height="200px" alt="Book 3">
                    <p>Ghost in machine</p>
                </div>

                <div class="book">
                    <img src="style/images/this.jpg" width="200px" height="200px" alt="Book 1">
                    <p>Revenge of the ghost</p>
                </div>

            </div>
        </section>

    </main>

    <footer>
        <p>&copy; 2024 Library Dashboard. All rights reserved.</p>
    </footer>
</div>
</body>
</html>
    