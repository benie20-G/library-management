package Controllers;

import java.io.IOException;

import Models.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name ="ViewServlet", value = "/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        UserDao user =null;
        user.getProfile(request.getParameter("email")); 
        
        
        request.setAttribute("user", user);
        
       
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
