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
 * Servlet implementation class setpassservlet
 */
public class setpassservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("helloo");
		String email = request.getParameter("email");
		String npass = request.getParameter("newpass");
		String cpass = request.getParameter("newcpass");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if (npass.equals(cpass)) {
			System.out.println("helloo1");
			logindao ldao = new logindao();
			loginbean user = ldao.user(email);
			System.out.println("user name-"+user.getUname());
			if (user.getUname() != null) {
				boolean login = ldao.resetpassuser(email, cpass);
				System.out.println("boolean-"+login);
				
				if (login) {
					System.out.println("insde login true--->");
					request.setAttribute("logininfo",user );
					request.getRequestDispatcher("Welcome.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "Login Successfull!");
					request.setAttribute("errormessage", "Invalid Password");
					request.getRequestDispatcher("Passset.jsp").forward(request, response);
				}
			}
			else
			{
				out.println("<script>alert('User does not exists!');location='Passset.jsp';</script>");
			}
		}
		else
		{
			request.setAttribute("errormessage","Password Missmatch" );
			request.getRequestDispatcher("Passset.jsp").forward(request, response);
		}
	}
}
