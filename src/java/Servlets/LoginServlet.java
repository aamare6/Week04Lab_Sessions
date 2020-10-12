
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;


public class LoginServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         // create session
        HttpSession session = request.getSession();
        
        String logout = request.getParameter("logout");
        if (logout != null) {
            session.invalidate();
        // display message 
        request.setAttribute("logOutMessage", "Successfully logged out.");
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        
        
        if ( session.getAttribute("username") != null) {  
        response.sendRedirect("home"); 
        } 
        else {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         // create session
        HttpSession session = request.getSession();
        
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         AccountService  acc = new AccountService(username, password); 
         User user = new User();
        // check is username and password not empty 
        if (username != null || !username.isEmpty() || password != null || !password.isEmpty()) {
     
           user = acc.login(username, password);
         
        }
       
           if (user != null) {
           session.setAttribute("username", username);
         response.sendRedirect("home");
           } else {
           request.setAttribute("username", username);
           request.setAttribute("password", password);
           request.setAttribute("Message", "Username or password entered is invalid.");
           // forward to login.jsp 
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           }
        
        
        }
}
