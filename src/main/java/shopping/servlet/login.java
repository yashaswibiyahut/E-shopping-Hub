package shopping.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.bean.loginbean;
import shopping.configdao.logindao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String uemail=request.getParameter("uemail");
				String upass=request.getParameter("upass");
				
				try
				{
				logindao ldao=new logindao();
				loginbean login=ldao.checkuser(uemail,upass);
				System.out.println("sevlet--->");
				if(login.getUname()!=null)
				{
					if(login.getUname().equals("Admin"))
					{
						request.setAttribute("logininfo", login);
						RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
						rd.forward(request, response);
					}
					else {
					/*	HttpSession session=request.getSession();
						session.setAttribute("login", login.getUname());*/
					request.setAttribute("logininfo", login);
					RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
					rd.forward(request, response);
					}
				}
				else
				{
					boolean user=ldao.userexists(uemail);
					if(user)
					{
						request.setAttribute("errormessage","User does not exists! Please create account.");
						request.getRequestDispatcher("index.jsp").forward(request,response);
					}
					else
					{
						request.setAttribute("errormessage","Invalid Email/Password");
						request.getRequestDispatcher("index.jsp").forward(request,response);
					}
				}
	}
	catch(Exception e)
	{ System.out.println(e); }
	}
}
