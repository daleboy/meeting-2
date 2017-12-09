package edu.buu.meeting.biz;

import java.util.List;

import edu.buu.meeting.dao.DepartmentDao;
import edu.buu.meeting.entity.Department;

public class DepartmentBiz {
	DepartmentDao dao = new DepartmentDao();

	// ��Ӳ���
	public void insertDep(String departmentname) {
		try {
			dao.insertDepinfo(departmentname);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.closeConnection();
		}

	}

	// ɾ������
	public void deleteDep(int departmentid) {
		try {
			dao.deleteById(departmentid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			dao.closeConnection();
		}
	}

	// �޸Ĳ���
	public void updateDep(int departmentid,String departmentname) {
		try {
			dao.updateById(departmentname, departmentid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			dao.closeConnection();
		}
	}

	// ��ѯ���в���
	public List<Department> selectAllDep() {
		List<Department> list = null;
		try {
			list = dao.selectAllDep();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			dao.closeConnection();
		}

		return list;
	}

}
