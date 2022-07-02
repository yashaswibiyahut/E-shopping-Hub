package shopping.configdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import shopping.bean.loginbean;

public class logindao {
	public loginbean showuser(String uemail)
	{
		loginbean lbean=new loginbean();
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			System.out.println("In daoConnected");
			if(c!=null)
			{
				PreparedStatement  ps=c.prepareStatement("select * from user where email=?");
				ps.setString(1,uemail);
				ResultSet rs=ps.executeQuery();  
				if(rs.next())
				{
					
					lbean.setUname(rs.getString("name"));
					lbean.setUemail(rs.getString("email"));
					lbean.setUcontact(rs.getString("contact"));
				}
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lbean;
	}

	public loginbean checkuser(String uemail, String upass) {
		
		loginbean lbean=new loginbean();
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			System.out.println("-->"+c);
			if(c!=null)
			{
				System.out.println("if -->");
				PreparedStatement  ps=c.prepareStatement("select * from user where email=?");
				ps.setString(1,uemail);
				ResultSet rs=ps.executeQuery();  
				System.out.println("-resultset");
				if(rs.next())
				{
					System.out.println(rs.getString("password"));
					if(rs.getString("password").equals(upass))
					{
						lbean.setUname(rs.getString("name"));
					}
					
				}System.out.println("-->"+lbean.getUname());
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lbean;
	}
	
public loginbean user(String uemail) {
		
		loginbean lbean=new loginbean();
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			System.out.println("-->"+c);
			if(c!=null)
			{
				System.out.println("if -->");
				PreparedStatement  ps=c.prepareStatement("select * from user where email=?");
				ps.setString(1,uemail);
				ResultSet rs=ps.executeQuery();  
				System.out.println("-resultset");
				if(rs.next())
				{
					System.out.println(rs.getString("password"));
					
						lbean.setUname(rs.getString("name"));
					
					
				}System.out.println("-->"+lbean.getUname());
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lbean;
	}

public boolean userexists(String uemail) {
		
		loginbean lbean=new loginbean();
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			if(c!=null)
			{
				PreparedStatement  ps=c.prepareStatement("select * from user where email=?");
				ps.setString(1,uemail);
				ResultSet rs=ps.executeQuery();  
				
				if(rs.next())
				{
					System.out.println("if-->"+lbean.getUname());
					return true;
				}
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public boolean newuser(String uname, String uemail, String ucontact, String upass) {
		
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			if(c!=null)
			{
				PreparedStatement  ps=c.prepareStatement("insert into user values(?,?,?,?)");
				ps.setString(1,uname);
				ps.setString(2,uemail);
				ps.setString(3,ucontact);
				ps.setString(4,upass);
				ps.executeUpdate();  
				System.out.println("Record Inserted");
				return true;
			}
			System.out.println("Record Not Inserted");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	public boolean resetpassuser(String email, String cpass) {
		loginbean lbean=new loginbean();
		try {
			System.out.println("Inside resetpassuser");
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			if(c!=null)
			{
				System.out.println("Connection not null");
				PreparedStatement  ps=c.prepareStatement("update user set password=? where email=?");
				ps.setString(1,cpass);
				ps.setString(2,email);
				int result=ps.executeUpdate();
				System.out.println(result);
				if(result!=0)
				{
				lbean.setUpass(cpass);
				System.out.println("Updated Successfully");
				return true;
				}
				else
				{
					//out.println("<script>alert('Reset Failed! Please try again.');location='Resetpass.jsp';</script>");
					System.out.println("Updated Failed");
					return false;
				}
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}


}
