package shopping.configdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import shopping.bean.categorybean;
import shopping.bean.loginbean;

public class categorydao {

	public boolean addcategory(String cat,String desc) {
		categorybean cbean=new categorybean();
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			System.out.println("In daoConnected");
			if(c!=null)
			{	int id=cbean.getId();
				PreparedStatement  ps=c.prepareStatement("insert into addopertaion(title,description) values(?,?)");
				
				ps.setString(1,cat);
				ps.setString(2,desc);
				ps.executeUpdate();  
				System.out.println("Record Inserted");
				return true;
			}
			System.out.println("Record not Inserted");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	
	
	public List<categorybean> getcatageory()
	{
		List <categorybean> returnStrings = new ArrayList <categorybean>();
		System.out.println("Hello there");
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
		//	System.out.println("In daoConnected");
			if(c!=null)
			{
				
				PreparedStatement  ps=c.prepareStatement("select * from addopertaion");
				ResultSet rs=ps.executeQuery();  
				//System.out.println("getcategory");
				while(rs.next())
				{
					categorybean cbean=new categorybean();
					System.out.println("getcategory title"+rs.getString("title"));
					System.out.println("getcategory id"+rs.getInt("id"));
					cbean.setCtitle(rs.getString("title"));
					cbean.setId(rs.getInt("id"));
					returnStrings.add(cbean);
					
				}
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return returnStrings;
	}
	



	public int categoryid(String cattitle) {
		int cid=0;
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			System.out.println("In daoConnected");
			if(c!=null)
			{
				PreparedStatement  ps=c.prepareStatement("select id from addopertaion where title=?");
				ps.setString(1,cattitle);
				ResultSet rs=ps.executeQuery();  
				if(rs.next())
				{
					
					cid=rs.getInt("id");
					System.out.println("cid="+cid);
				}
		
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return cid;
	}

}
