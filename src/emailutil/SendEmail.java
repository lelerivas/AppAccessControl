package emailutil;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	private static final String HOSTMAIL = "smtp.gmail.com";
	private static final String USERNAME = "cotiinformatica1@gmail.com";
	private static final String PASSWORD = "aulaJava";

	
	public static Email configureEmail(){
		Email email = new SimpleEmail();
		email.setHostName(HOSTMAIL);
		email.setSmtpPort(465);
		email.setAuthentication(USERNAME, PASSWORD);
		email.setSSL(true);
		email.setTLS(true);
		return email;
	}
	
	public static void sendEmail(String msg, String email) throws Exception{
		Email emailconf = configureEmail();
		emailconf.setSubject("Java Control Access System - New Password.");
		emailconf.setMsg(msg);
		emailconf.setFrom(USERNAME," Java Control Access System - By Elenice Rivas.");
		emailconf.addTo(email);
		emailconf.send();
	}
}
