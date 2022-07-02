package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.bean.loginbean;
import shopping.configdao.logindao;

/**
 * Servlet implementation class signupservlet
 */
public class signupservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String uemail=request.getParameter("uemail");
		String ucontact=request.getParameter("ucontact");
		String upass=request.getParameter("upass");

		
		logindao ldao=new logindao();
		boolean login=ldao.newuser(uname,uemail,ucontact,upass);
		System.out.println("Signupsevlet--->");
		//request.setAttribute("logininfo", login);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if(login)
		{
			System.out.println("in signupservlet");
			out.println("<script>alert('Sign Up Successful.');location='index.jsp';</script>");
		/*RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);*/
		}
		else
		{	out.println("<script>alert('Sign Up Fail.');location='Signup.jsp';</script>");
			/*out.println("alert('Sign Up fail! Please try again')");
			RequestDispatcher rd=request.getRequestDispatcher("Signup.jsp");
			rd.forward(request, response);*/
		}
}
	}

