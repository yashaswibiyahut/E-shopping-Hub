package shopping.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.bean.productbean;
import shopping.configdao.configdao;

@WebServlet("/image")
public class imageservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Image servlet");
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			String fname=request.getParameter("filename");
			System.out.println("In daoConnected");
			if(c!=null)
			{
				PreparedStatement  ps=c.prepareStatement("select file from addproduct where filename=?");
				ps.setString(1, fname);
				ResultSet rs=ps.executeQuery();  
				
				while(rs.next())
				{
					 byte[] imgdata=null;
						
						Blob img=null;
						img=rs.getBlob("file");
						imgdata=img.getBytes(1,(int)img.length());
						response.setContentType("image/gif");
						OutputStream o=response.getOutputStream();
						o.write(imgdata);
						o.flush();
						o.close();
					
				}
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}


}
