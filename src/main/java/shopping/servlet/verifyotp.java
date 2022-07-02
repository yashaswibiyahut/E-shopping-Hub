package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import shopping.bean.loginbean;
import shopping.configdao.logindao;

/**
 * Servlet implementation class verifyotp
 */

public class verifyotp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uotp=request.getParameter("uotp");
		System.out.println("user OTP "+uotp);
		String votp=request.getParameter("votp");
		//otp=(String) request.getAttribute("verifyotp");
		System.out.println("OTP "+votp);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if(uotp.equals(votp))
		{
			//JOptionPane.showMessageDialog(null, "Login successfully!");
			//request.setAttribute("message","Login successfully");
			RequestDispatcher rd=request.getRequestDispatcher("Passset.jsp");
			rd.forward(request, response);
		}
		else
		{
			//JOptionPane.showMessageDialog(null, "Wrong OTP");
			//out.println("<script>alert('Login Fail');location='Resetpass.jsp';</script>");
			request.setAttribute("errormessage","Incorrect OTP" );
			request.getRequestDispatcher("Resetpass.jsp").forward(request, response);
		}
	}

}
