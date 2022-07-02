package shopping.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shopping.bean.categorybean;
import shopping.bean.loginbean;
import shopping.bean.productbean;
import shopping.configdao.categorydao;
import shopping.configdao.logindao;
import shopping.configdao.productDao;

/**
 * Servlet implementation class productservlet
 */
@MultipartConfig
public class productservlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if (op.trim().equals("addcategory")) {
			String category = request.getParameter("categorytitle");
			String disc = request.getParameter("categorydis");
			try {
				categorydao catdao = new categorydao();
				boolean cat = catdao.addcategory(category,disc);
				System.out.println(cat);
				if(cat==true) {
				//out.println("Category Added");
					request.setAttribute("Catmessage","Category Added");
					RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				}
				else
				{
					//out.println("Category Not Added!");
					request.setAttribute("Caterrormessage","Category Not Added!" );
					RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (op.trim().equals("addproduct")) {
			String pname = request.getParameter("proname");
			String prodesc = request.getParameter("prodesc");
			int pprice = Integer.parseInt(request.getParameter("proprice"));
			int pquantity = Integer.parseInt(request.getParameter("proquantity"));
			String cattitle = request.getParameter("cattitle");
			Part part=request.getPart("ppic");
			categorydao catdao = new categorydao();
			int catid = catdao.categoryid(cattitle);	
				try {
					productbean pbean=new productbean();
					pbean.setProname(pname);
					pbean.setProdesc(prodesc);
					pbean.setProprice(pprice);
					pbean.setProquantity(pquantity);
					pbean.setPphoto(part.getSubmittedFileName());
					pbean.setCatid(catid);
					InputStream is=part.getInputStream();
					productDao pdao=new productDao();
					boolean res=pdao.addproduct(pname,prodesc,pprice,pquantity,part.getSubmittedFileName(),catid,is);
					
					//String path="D:\\Workkspace\\shopping\\img\\Products"+File.separator+part.getSubmittedFileName();
					//System.out.println(path);
					/*try {
						//FileOutputStream fos=new FileOutputStream(path);
						
						byte[] data=new byte[is.available()];
						is.read(data);
						fos.write(data);
						fos.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					System.out.println(res);
					if(res==true) {
						//out.println("Category Added");
						System.out.println(res);
							request.setAttribute("Promessage","Product Added");
							RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
							rd.forward(request, response);
						}
						else
						{
							//out.println("Category Not Added!");
							request.setAttribute("Proerrormessage","Category Not Added!" );
							RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
							rd.forward(request, response);
						}
					
				}
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
