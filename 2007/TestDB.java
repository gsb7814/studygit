package guo.sql;

import java.sql.*;

/*
 * 使用DbUtil类实现数据库操作。
 */
public class TestDB {
	
	
	public static void prtResultSet(ResultSet rs)
	{
		if(rs!=null)
		{
			try{
				ResultSetMetaData meta = rs.getMetaData();
				
				System.out.print(meta.getColumnName(1)+"\t");
				System.out.print(meta.getColumnName(2)+"\t");
				System.out.print(meta.getColumnName(3)+"\t");
				System.out.print(meta.getColumnName(4)+"\t\n");
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getInt(4)+"\t\n");
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 用jdbc-odbc桥连接数据库
		System.out.println("用jdbc-odbc桥连接数据库");
		String dbDriver ="sun.jdbc.odbc.JdbcOdbcDriver";
		String url="jdbc:odbc:stu";//odbc数据源名称
		DbUtil db = new DbUtil(url,dbDriver);
		db.getConnection("sa","sa");
		String sql = "select * from stuInfo";
		ResultSet rs = db.exeQuery(sql);
		prtResultSet(rs);
		db.disconnection();
		/*//用jdbc直连
		System.out.println();
		System.out.println("用jdbc直连");
		String dbDriver1 ="com.microsoft.jdbc.sqlserver.SQLServerDriver";
		String url1="jdbc:Microsoft:sqlserve://localhost:1433;databaseName=student";
		String userName="sa";
		String password="sa";
		DbUtil db1 = new DbUtil(url1,dbDriver1);
		db1.getConnection(userName,password);
		//String sql1 = "insert into stuInfo(number,name,sex,age) values(4,\"刘小华\",\"男\",30)";
		//int n = db1.exeUpdate(sql1);
		ResultSet rs1 = db1.exeQuery(sql);
		prtResultSet(rs1);
		db.disconnection();
		*/
		//用jdbc直连
		/*System.out.println();
		System.out.println("用jdbc直连");
		String dbDriver1 ="com.mysql.jdbc.Driver";
		String url1="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=GB2312";
		String userName="root";
		String password="";
		DbUtil db1 = new DbUtil(url1,dbDriver1);
		db1.getConnection(userName,password);
		ResultSet rs1 = db1.exeQuery(sql);
		prtResultSet(rs1);
		System.out.println(" 插入记录后");
		String sql1 = "insert into stuInfo(number,name,sex,age) values(4,'刘小华','ma',30)";
		int n = db1.exeUpdate(sql1);
		rs1 = db1.exeQuery(sql);
		prtResultSet(rs1);
		db1.disconnection();*/
	}

}
