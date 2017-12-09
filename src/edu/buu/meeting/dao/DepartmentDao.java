package edu.buu.meeting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.buu.meeting.entity.Department;

public class DepartmentDao extends BaseDao {
	// ����һ������
	public int insertDepinfo(String Departmentname) throws Exception {
		this.openConnection();
		String sql = "insert into Department(Departmentname) value(?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, Departmentname);
		pst.execute();// ִ�����
		return pst.getUpdateCount();
	}

	// ��ѯһ������
	public Department selectById(int Departmentid) throws Exception {
		this.openConnection();
		String sql = "select Departmentname from Department where Departmentid=?";
		PreparedStatement pst = conn.prepareStatement(sql);// ����ִ��SQL����statement--ʹ��PrepareStatement
		pst.setInt(1, Departmentid);
		ResultSet rs = pst.executeQuery();
		Department Department = null;
		while (rs.next()) {
			Department = new Department();
			Department.setDepartmentname(rs.getString("Departmentname"));
		}
		return Department;// ����һ�����ϣ���Ҫ�޸ķ���ֵ����
	}

	// ��ѯһ���������
	public List<Department> selectAllDep() throws Exception {
		this.openConnection();
		String sql = "select * from Department";
		PreparedStatement pst = conn.prepareStatement(sql);// ����ִ��SQL����statement--ʹ��PrepareStatement
		ResultSet rs = pst.executeQuery();
		List<Department> list = new ArrayList<Department>();// ����һ�����϶��������������б�
		Department Department = null;
		while (rs.next()) {
			Department = new Department();
			Department.setDepartmentid(rs.getInt("Departmentid"));
			Department.setDepartmentname(rs.getString("Departmentname"));
			list.add(Department);// ÿ�����ݶ��洢��list������
		}
		return list;// ����һ�����ϣ���Ҫ�޸ķ���ֵ����
	}

	// ɾ��һ������
	public int deleteById(int Departmentid) throws Exception {
		this.openConnection();
		String sqldel = "delete from Department where Departmentid=?";
		PreparedStatement pstdel = conn.prepareStatement(sqldel);
		pstdel.setInt(1, Departmentid);
		int num = pstdel.executeUpdate();
		return num;
	}

	// �޸�һ����Ϣ
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
