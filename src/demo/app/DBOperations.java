package demo.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBOperations 
{
	public static void InsertData(String sno,String name,String city,String mobile)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/excel","root", "1237");
			
			PreparedStatement pst=con.prepareStatement("insert into students values(?,?,?,?)");
			
			pst.setInt(1, Integer.parseInt(sno));
			pst.setString(2, name);
			pst.setString(3, city);
			pst.setString(4, mobile);
			
			int l=pst.executeUpdate();
			if(l>0)
			{
				System.out.println(sno+"Inserted Sucesfully");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(sno+"Fail to Insert");
		}
		
			
	}

	public static ResultSet GetData() {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from students");
			return rs;
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	}

