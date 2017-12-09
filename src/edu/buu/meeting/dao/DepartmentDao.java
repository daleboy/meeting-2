package edu.buu.meeting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.buu.meeting.entity.Department;

public class DepartmentDao extends BaseDao {
	// 插入一条数据
	public int insertDepinfo(String Departmentname) throws Exception {
		this.openConnection();
		String sql = "insert into Department(Departmentname) value(?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, Departmentname);
		pst.execute();// 执行语句
		return pst.getUpdateCount();
	}

	// 查询一条数据
	public Department selectById(int Departmentid) throws Exception {
		this.openConnection();
		String sql = "select Departmentname from Department where Departmentid=?";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		pst.setInt(1, Departmentid);
		ResultSet rs = pst.executeQuery();
		Department Department = null;
		while (rs.next()) {
			Department = new Department();
			Department.setDepartmentname(rs.getString("Departmentname"));
		}
		return Department;// 返回一个集合，需要修改返回值类型
	}

	// 查询一个表的数据
	public List<Department> selectAllDep() throws Exception {
		this.openConnection();
		String sql = "select * from Department";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		ResultSet rs = pst.executeQuery();
		List<Department> list = new ArrayList<Department>();// 创建一个集合对象来接收数据列表
		Department Department = null;
		while (rs.next()) {
			Department = new Department();
			Department.setDepartmentid(rs.getInt("Departmentid"));
			Department.setDepartmentname(rs.getString("Departmentname"));
			list.add(Department);// 每条数据都存储到list集合里
		}
		return list;// 返回一个集合，需要修改返回值类型
	}

	// 删除一条数据
	public int deleteById(int Departmentid) throws Exception {
		this.openConnection();
		String sqldel = "delete from Department where Departmentid=?";
		PreparedStatement pstdel = conn.prepareStatement(sqldel);
		pstdel.setInt(1, Departmentid);
		int num = pstdel.executeUpdate();
		return num;
	}

	// 修改一条信息
	public int updateById(String Departmentname, int Departmentid) throws Exception {
		this.openConnection();
		String sqlupdate = "update Department set Departmentname=? where Departmentid=?";
		PreparedStatement pstupdate = conn.prepareStatement(sqlupdate);
		pstupdate.setString(1, Departmentname);
		pstupdate.setInt(2, Departmentid);
		int num = pstupdate.executeUpdate();
		return num;
	}
}
