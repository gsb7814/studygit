package guo.db.dao;

import java.sql.SQLException;
import java.util.List;

import guo.db.DBUtil;

abstract public class BaseDAO {
	private DBUtil dbUtil = null;
	private static String cfgFile = "DBConfig.xml";

	public BaseDAO() {
		if (dbUtil == null) {
			dbUtil = new DBUtil(getConfigFile(cfgFile));
		}
	}
	
	public int executeUpdate(String sql) {
		int rows = 0;
		try {
			rows = dbUtil.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public abstract List executeQuery(String sql);
	/*public List executeQuery(String sql) {
		List list = null;
		try {
			list = dbUtil.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}*/

	private String getConfigFile(String filename) {
		return getClass().getResource(filename).getPath();
	}

	public static String getCfgFile() {
		return cfgFile;
	}

	public static void setCfgFile(String cfgFile) {
		BaseDAO.cfgFile = cfgFile;
	}
}
