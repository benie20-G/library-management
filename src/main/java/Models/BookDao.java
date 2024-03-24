package Models;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.BookModel;
import Utils.DbConnection;

public class BookDao {
    public void addBook(BookModel book) {
        String query = "INSERT INTO book (name, author, publisher, publication_date, subject) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)) {
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setString(4, book.getPublicationDate());
            ps.setString(5, book.getSubject());
            ps.executeUpdate();
            System.out.println("Book is now stored in the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<BookModel> searchBooksByName(String name) {
        ArrayList<BookModel> matchedBooks = new ArrayList<>();

        String query = "SELECT * FROM book WHERE name LIKE ?";
        try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String bookName = rs.getString("name");
                    String author = rs.getString("author");
                    String publisher = rs.getString("publisher");
                    String publicationDate = rs.getString("publication_date");
                    String subject = rs.getString("subject");

                    BookModel book = new BookModel(bookName, author, publisher, publicationDate, subject);
                    matchedBooks.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matchedBooks;
    }
}
