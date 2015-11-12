package guo.sql;

import java.sql.*;

/*
 * ʹ��DbUtil��ʵ�����ݿ������
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
		// ��jdbc-odbc���������ݿ�
		System.out.println("��jdbc-odbc���������ݿ�");
		String dbDriver ="sun.jdbc.odbc.JdbcOdbcDriver";
		String url="jdbc:odbc:stu";//odbc����Դ����
		DbUtil db = new DbUtil(url,dbDriver);
		db.getConnection("sa","sa");
		String sql = "select * from stuInfo";
		ResultSet rs = db.exeQuery(sql);
		prtResultSet(rs);
		db.disconnection();
		/*//��jdbcֱ��
		System.out.println();
		System.out.println("��jdbcֱ��");
		String dbDriver1 ="com.microsoft.jdbc.sqlserver.SQLServerDriver";
		String url1="jdbc:Microsoft:sqlserve://localhost:1433;databaseName=student";
		String userName="sa";
		String password="sa";
		DbUtil db1 = new DbUtil(url1,dbDriver1);
		db1.getConnection(userName,password);
		//String sql1 = "insert into stuInfo(number,name,sex,age) values(4,\"��С��\",\"��\",30)";
		//int n = db1.exeUpdate(sql1);
		ResultSet rs1 = db1.exeQuery(sql);
		prtResultSet(rs1);
		db.disconnection();
		*/
		//��jdbcֱ��
		/*System.out.println();
		System.out.println("��jdbcֱ��");
		String dbDriver1 ="com.mysql.jdbc.Driver";
		String url1="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=GB2312";
		String userName="root";
		String password="";
		DbUtil db1 = new DbUtil(url1,dbDriver1);
		db1.getConnection(userName,password);
		ResultSet rs1 = db1.exeQuery(sql);
		prtResultSet(rs1);
		System.out.println(" �����¼��");
		String sql1 = "insert into stuInfo(number,name,sex,age) values(4,'��С��','ma',30)";
		int n = db1.exeUpdate(sql1);
		rs1 = db1.exeQuery(sql);
		prtResultSet(rs1);
		db1.disconnection();*/
	}

}
