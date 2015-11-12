package guo.db;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;

/**
 *
 * <p>Title: 业务管理子系统</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Shangbo Guo Copyright (c) 2007</p>
 *
 * <p>Company: </p>
 * 2007-11-28
 * @author Shangbo Guo
 * @version 1.1
 */
public class DBUtil {
	/**
	 * 实现数据库操作的实用类，封装了事务处理，增删查改等操作。
	 */
	private String dbURL = null;
	private String dbDriver = null;
	private String username = null;
	private String password = null;
	private Connection conn = null;
	private List <String> transaction = new ArrayList<String>();
	private boolean inTransaction = false;

	public DBUtil(String dbCfgFile) {
		try {
			Properties props = new Properties();
//			props.loadFromXML(this.getClass().getResourceAsStream(dbCfgFile));
			props.loadFromXML(new BufferedInputStream(new FileInputStream(dbCfgFile)));

			dbURL = props.getProperty("dbURL");
			dbDriver = props.getProperty("dbDriver");
			username = props.getProperty("username");
			password = props.getProperty("password");
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DBUtil(String dbURL, String dbDriver, 
			String username, String password) {
		this.dbURL = dbURL;
		this.dbDriver = dbDriver;
		this.username = username;
		this.password = password;

	}
	
	private Connection getConnection() {
		try {
			Class.forName(dbDriver);
			if (username == null || password == null) {
				conn = DriverManager.getConnection(dbURL);
			} else {
				conn = DriverManager.getConnection(dbURL,username,password);
			}
			
			if(conn != null)
	            conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Connection getConnection(DataSource ds) {
		try {
			conn = ds.getConnection();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
		
	@SuppressWarnings("unchecked")
	public List executeQuery(String sql) throws SQLException {
		return executeQuery(sql, false);
	}
	
	@SuppressWarnings("unchecked")
	public List executeQuery(SQLStatement sql) throws SQLException {
		return executeQuery(sql.toString(), false);
	}
	
	@SuppressWarnings("unchecked")
	public List executeQuery(SQLStatement sql, boolean showHeader) throws SQLException {
		return executeQuery(sql.toString(), showHeader);
	}

	@SuppressWarnings("unchecked")
	public List executeQuery(String sql, boolean showHeader)
			throws SQLException {

		conn = getConnection();
		List result = new ArrayList();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			int colCount = meta.getColumnCount();
			if (showHeader) {
				List<ColumnInfo> header = new ArrayList<ColumnInfo>();
				for (int i = 1; i <= colCount; i++) {
					String name = meta.getColumnName(i);
					name = (name == null ? "" : name);
					header.add(new ColumnInfo(name,
							meta.getColumnClassName(i)));
				}

				result.add(header);
			}
			

			for (; rs.next(); ) {
				List row = new ArrayList();
				for (int i = 1; i <= colCount; i++) {
					Object cell = rs.getObject(i);
					if (cell != null && (cell instanceof String)) {
						cell = (String) cell;
					}
					row.add(cell);
				}
				result.add(row);
			}
			
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
			e.printStackTrace();
			}
		if (!inTransaction && conn != null) {
			conn.close();
			conn = null;
		}
		return result;
	}

	public int executeUpdate(String sql) throws SQLException{

		int n = 0;
		conn = getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			n = stmt.executeUpdate(sql);
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if(stmt != null)
                stmt.close();
		}
		if(!inTransaction && conn != null)
        {
            conn.close();
            conn = null;
        }
		return n;
	}

	/**
	 * 执行事务处理
	 * 
	 * @param batch
	 * @return
	 */
	@Deprecated
	public int[] exeTransaction(String batch) {
		int nums[] = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sqls[] = batch.split("#");
			for (int i = 0; i < sqls.length; i++) {
				stmt.addBatch(sqls[i]);
			}
			nums = stmt.executeBatch();
			conn.commit();
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nums;
	}
	
	public int[] executeTransaction() throws SQLException {
		beginTransaction();
		ArrayList<Integer> iRets = new ArrayList<Integer>();
		for (int i = 0; i < transaction.size(); i++) {
			Object obj = transaction.get(i);
			if (obj == null)
				continue;
			String sql = obj.toString();
			int iRet = executeUpdate(sql);
			iRets.add(new Integer(iRet));
			continue;
		}

		commitTransaction();
		endTransaction();
		int rets[] = new int[iRets.size()];
		for (int i = 0; i < rets.length; i++)
			rets[i] =iRets.get(i).intValue();

		return rets;
	}

	public void beginTransaction() throws SQLException {
		conn = getConnection();
		conn.setAutoCommit(false);
		inTransaction = true;
	}
	
	public void endTransaction() throws SQLException {
		if (inTransaction) {
			try {
				conn.close();
			} catch (SQLException e) {
				conn = null;
				inTransaction = false;
			}
			conn = null;
			inTransaction = false;
		}
	}
	
	public void clearTransation() {
		transaction.clear();
	}
	
	public void commitTransaction() throws SQLException {
		if (inTransaction)
			conn.commit();
	}

	public void rollbackTransaction() throws SQLException {
		if (inTransaction)
			conn.rollback();
	}

	public void rollbackTransaction(Savepoint savepoint) throws SQLException {
		if (inTransaction)
			conn.rollback(savepoint);
	}

	public void addTransaction(String sql) {
		transaction.add(sql);
	}
}
