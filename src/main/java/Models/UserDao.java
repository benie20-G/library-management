package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.DbConnection;
public class UserDao{
	public void createUser(UserModel user) {
	    String query = "INSERT INTO user (firstName, lastName, account, email,password) VALUES (?,?, ?, ?, ?)";
	    try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)) {
	        ps.setString(1, user.getFirstName());
	        ps.setString(2, user.getLastName());
	        ps.setString(3, user.getAccount());
	        ps.setString(4, user.getEmail());
	        ps.setString(5, user.getPassword());
	        ps.executeUpdate();
			System.out.println("User is now registered in database");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	 public static String getUserByEmail(String email) {
	        String query = "SELECT firstName, lastName FROM user WHERE email = ?";
	        try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)) {
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return rs.getString("firstName") + " "+ rs.getString("lastName");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 public UserModel getProfile(String email) {
		    String query = "SELECT firstName, lastName, account, email, password FROM user WHERE email=?";
		    try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(query)) {
		        ps.setString(1, email);
		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            String firstName = rs.getString("firstName");
		            String lastName = rs.getString("lastName");
		            String account = rs.getString("account");
		            String userEmail = rs.getString("email");
					String password = rs.getString("password");
					return new UserModel(firstName, lastName,account, userEmail,password);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return null; // Return null if user not found

		}
		


}

