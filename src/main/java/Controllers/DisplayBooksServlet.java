package Controllers;

import Utils.DbConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/DisplayBooksServlet")
public class DisplayBooksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList<Book>();

        try {
            // Get database connection from DbConnection class
            conn = DbConnection.getConnection();

            // Query to retrieve book information
            String query = "SELECT name, author, publisher, publication_date, subject FROM book";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            // Retrieve book information and store in ArrayList
            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String publicationDate = rs.getString("publication date");
                String subject = rs.getString("subject");

                Book book = new Book(name, author, publisher, publicationDate, subject);
                books.add(book);
            }

            // Forward data to JSP
            request.setAttribute("books", books);
            request.getRequestDispatcher("/display_book.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
