package Controllers;

import java.io.IOException;

import Models.UserDao;
import Models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Filters.IsValid.*;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UserDao userDao; 
   public void init() {
	   userDao=new UserDao();
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String firstname=request.getParameter("firstname");
	   String lastname=request.getParameter("lastname");
	   String account=request.getParameter("account");
	   String email=request.getParameter("email");
	   String password=request.getParameter("password");
	   String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

	   // Check if the password matches the regex
	   if (!password.matches(passwordRegex)) {
		   response.sendRedirect(request.getContextPath() + "/errorPassword.jsp");
		   return;
	   }


	    UserModel user=new UserModel(firstname,lastname,account,email,password);
	    userDao.createUser(user);
	    response.sendRedirect(request.getContextPath() + "/dashboard.jsp?username=" + firstname + " "+lastname);
	}


}
