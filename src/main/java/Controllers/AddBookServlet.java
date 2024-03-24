package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.BookDao;
import Models.BookModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Utils.DbConnection;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String publicationDate = request.getParameter("publicationDate");
        String subject;
        subject = request.getParameter("subject");

        // Create a BookModel object with the provided details
        BookModel book = new BookModel(name, author, publisher, publicationDate, subject);

        // Create an instance of BookDao
        BookDao bookDao = new BookDao();

        // Call the addBook method of BookDao to store the book in the database
        bookDao.addBook(book);

        // Redirect back to the add book page with a success message
        response.sendRedirect("dashboard.jsp");
    }
}