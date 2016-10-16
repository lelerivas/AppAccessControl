package controller;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import persistence.UserDao;
import sun.misc.BASE64Encoder;
			  
@WebServlet("/accesscontrol")
public class AccessControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccessControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passwordcrip = md.digest(password.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			
			User user = new UserDao().search(email, encoder.encode(passwordcrip));

			if(user!=null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("restrict/home.jsp");
			}else{
				request.setAttribute("msg", "Access deny.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", "Problem: "+e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}		
	}
}
