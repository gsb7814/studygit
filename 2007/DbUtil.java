package guo.sql;

import java.sql.*;

/*
 * 数据库操作类
 */
public class DbUtil {
	
	private String url = null;
	private String DBdriver = null;
	private Connection conn = null;
	private ResultSet rs = null;
	Statement stmt = null;
	
	public DbUtil(String url,String DBdriver)
	{
		this.url = url;
		this.DBdriver = DBdriver;
		
	}
	
	public void getConnection()
	{
		try{
			Class.forName(DBdriver);
			conn = DriverManager.getConnection(url);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public void getConnection(String userName,String password)
	{
		try{
			Class.forName(DBdriver);
			conn = DriverManager.getConnection(url,userName,password);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet exeQuery(String sql)
	{	
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;	
	}
	
	public int exeUpdate(String sql)
	{
		 
		int n = 0;
		try {
			stmt = conn.createStatement();
			n = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;	
	}
	
	public void disconnection()
	{
		try {
			if(rs!=null)
			{
				rs.close();
				stmt.close();
			}
			else
			{
				stmt.close();
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
