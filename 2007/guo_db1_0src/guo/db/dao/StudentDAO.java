package guo.db.dao;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends BaseDAO {
	public ArrayList queryStuByName(String name) {
		
		String sql = "select * from student where sname like '%" + name + "%'";
		ArrayList list = (ArrayList)this.executeQuery(sql);
		return list;
	}
	
	public ArrayList queryStu() {
		String sql = "select * from student";
		ArrayList list = (ArrayList)this.executeQuery(sql);
		return list;
	}
	
	public void deleteStuById(String id) {
		String sql = "delete from student where id="+id;
		this.executeUpdate(sql);
	}
//	public static void main(String args[]) {
//		
//		StudentDAO dao = new StudentDAO();
//		ArrayList list = dao.queryStuByName("g");
//		if ( list.size() == 0) {
//			System.out.print("没有找到记录！");
//			return;
//		}
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}

	@Override
	public List executeQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
}
