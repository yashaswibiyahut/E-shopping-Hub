package shopping.servlet;

import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import shopping.bean.loginbean;
import shopping.configdao.logindao;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Message;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


import java.net.*;   
import java.io.*; 

/**
 * Servlet implementation class verifyOTPservlet
 */
@WebServlet("/generateOTPservlet")
public class generateOTPservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("here");
		String email=request.getParameter("uemail");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		logindao ldao = new logindao();
		boolean user = ldao.userexists(email);
		if(user)
		{
		Properties prop=new Properties();
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.transport.protocol", "SMTP");
		
		final String acc="aisha9609677551@gmail.com";
		final String password="Freebird@25";
		 Session session=Session.getInstance(prop, new Authenticator(){
			 @Override
			 protected PasswordAuthentication getPasswordAuthentication()
			 {
				 return new PasswordAuthentication(acc,password);
			 }
		 
		 });
		 
		 Message msg=new MimeMessage(session);
		 int OTP = 0;
		try {
			Random rand=new Random();
			OTP= rand.nextInt(9999);
			msg.setFrom(new InternetAddress(acc));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			msg.setSubject("OTP Verificiation");
			msg.setText("Hello welcome to E-shopping. Your OTP is "+OTP);
			System.out.println("here1");
			Transport.send(msg);
			System.out.println("here2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
/*		RequestDispatcher rd=request.getRequestDispatcher("Resetpass.jsp");
		rd.forward(request, response);*/
		System.out.println("email"+email);
		request.setAttribute("email",email);
		request.setAttribute("verifyotp", OTP);
		request.setAttribute("message","OPT sent successfully");
		request.getRequestDispatcher("Resetpass.jsp").forward(request,response);
	}
		else
		{
			request.setAttribute("errorusermessage","");
			request.getRequestDispatcher("Resetpass.jsp").forward(request,response);
		}
	}
}
