package shopping.configdao;

import java.sql.Connection;
import java.sql.DriverManager;

public class configdao {
/*	public static void main(String args[])
	{
		configdao v=new configdao();
		v.DaoConfig(); 
	}*/
	public Connection DaoConfig()
	{
		Connection c=null;
		try
		{
			System.out.print("In DB Config");
			Class.forName("com.mysql.jdbc.Driver");
			String cs="jdbc:mysql://localhost:3306/shopping";
			c=DriverManager.getConnection(cs,"root","root");
			if(c!=null)
				System.out.print("Connected");
			else
				System.out.print("Not Connected");
		}
		catch(Exception e)
		{ System.out.println(e); }
		return c;
	}
	

}
