package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import dateutil.DateConversion;
import emailutil.SendEmail;
import entity.Adress;
import entity.User;
import persistence.UserDao;
import sun.misc.BASE64Encoder;

@WebServlet({"/usercontrolreg","/newpassword"})
public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UserDao daouser;
	
    public UserControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verifyUrl(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verifyUrl(request, response);
	}

	protected void verifyUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();	
		if(daouser == null){
			daouser = new UserDao();
		}
				
		if(url.equals("/usercontrolreg")){
			registrerUser(request,response);
		}else if(url.equals("/newpassword")){
			generatepassword(request,response);
		}	
	}
	
	protected void registrerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String password = request.getParameter("password");

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passwordcrip = md.digest(password.getBytes());
			
			BASE64Encoder encoder = new BASE64Encoder();			
			
			User user = new User(
					null,
					request.getParameter("name"),
					request.getParameter("email"),
					DateConversion.convertingString(request.getParameter("birthday")),
					encoder.encode(passwordcrip));		
			
			Adress adress = new Adress(
					null,
					request.getParameter("street"),
					request.getParameter("neighborhood"),
					request.getParameter("city"));
			
			user.setAdress(adress);
			daouser.insert(user);
			
			request.setAttribute("msg", "User has inserted : "+user.toString());
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", "Problem: "+e.getMessage());
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}
	
	protected void generatepassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String email = request.getParameter("email");
			Random rd = new Random();
			String password = Integer.toHexString(rd.nextInt(9999999));
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passwordcrip = md.digest(password.getBytes());
			
			BASE64Encoder encoder = new BASE64Encoder();			
			
			daouser.alterPassword(email, encoder.encode(passwordcrip));
			
			SendEmail.sendEmail("New Passoword: "+password, email);
			request.setAttribute("msg", "Password has altered. Verify your Email");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", "Problem: "+e.getMessage());
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
