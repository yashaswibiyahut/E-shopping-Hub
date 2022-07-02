package shopping.configdao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import shopping.bean.categorybean;
import shopping.bean.productbean;

public class productDao {

	
	public boolean addproduct(String pname, String prodesc, int pprice, int pquantity,
			String submittedFileName, int catid, InputStream is) {
		productbean pbean=new productbean();
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			System.out.println("In daoConnected");
			System.out.println("catid="+catid);
			if(c!=null)
			{
				PreparedStatement  ps=c.prepareStatement("insert into addproduct(name,description,price,quantity,filename,catid,file) values(?,?,?,?,?,?,?)");
				
				ps.setString(1,pname);
				ps.setString(2,prodesc);
				ps.setInt(3, pprice);
				ps.setInt(4, pquantity);
				ps.setString(5,submittedFileName);
				ps.setInt(6, catid);
				ps.setBinaryStream(7,is,is.available());
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
	
	public List<productbean> getallproducts()
	{
		List <productbean> returnStrings = new ArrayList <productbean>();
		
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			System.out.println("In daoConnected");
			if(c!=null)
			{
				PreparedStatement  ps=c.prepareStatement("select * from addproduct");
				ResultSet rs=ps.executeQuery();  
				System.out.println("getproduct");
				while(rs.next())
				{
					productbean pbean=new productbean();
					pbean.setProname(rs.getString("name"));
					System.out.println(pbean.getProname());
					pbean.setProdesc(rs.getString("description"));
					pbean.setProprice(rs.getInt("price"));
					pbean.setProquantity(rs.getInt("quantity"));
					pbean.setPphoto(rs.getString("filename"));
					pbean.setFile(rs.getBlob("file"));
					returnStrings.add(pbean);
				}
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return returnStrings;
	}
	
	public List<productbean> getallproductsbyId(int id)
	{
		List <productbean> returnStrings = new ArrayList <productbean>();
		
		try {
			configdao con=new configdao();
			Connection c=con.DaoConfig();
			System.out.println("In daoConnected");
			if(c!=null)
			{
				PreparedStatement  ps=c.prepareStatement("select * from addproduct where catid=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();  
				System.out.println("getproduct");
				while(rs.next())
				{
					productbean pbean=new productbean();
					pbean.setProname(rs.getString("name"));
					System.out.println(pbean.getProname());
					pbean.setProdesc(rs.getString("description"));
					pbean.setProprice(rs.getInt("price"));
					pbean.setProquantity(rs.getInt("quantity"));
					pbean.setPphoto(rs.getString("filename"));
					pbean.setFile(rs.getBlob("file"));
					returnStrings.add(pbean);
				}
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return returnStrings;
	}

}
