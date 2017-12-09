package edu.buu.meeting.biz;

import java.util.List;

import edu.buu.meeting.dao.EmployeeDao;
import edu.buu.meeting.entity.Employee;
import edu.buu.meeting.util.ResultPage;

public class EmployeeBiz {
	private Employee employee;
	EmployeeDao dao = new EmployeeDao();

	// ��¼�ķ���
	public int login(String username, String password) {

		employee = null;
		int flag = 3;
		try {
			employee = dao.selectByLogin(username, password);
			// �û��������������ȷ����¼ʧ�ܣ������ȷ���ٿ�status����status=1.���¼�ɹ�
			// flag=3�û������벻��ȷ��flag=1��¼�ɹ���flag=0ע����������,flag=2ע������δͨ��
			if (employee != null) {
				String status = employee.getStatus();// ��ȡ�˻���״̬
				if (status != null && status.equals("0")) {
					flag = 0;
				} else if (status != null && status.equals("1")) {
					flag = 1;
				} else if (status != null && status.equals("2")) {
					flag = 2;
				}
			} else {
				flag = 3;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// ע�����˻�
	public int Register(Employee employee) {
		int flag = 0;
		try {
			dao.insertEmpinfo(employee);
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
		return flag;
	}

	// ��ȡԱ����Ϣ
	public Employee getEmployeeInfo() {
		return employee;
	}

	// ��֤�û����Ƿ����
	public Employee checkName(String username) {
		EmployeeDao dao = new EmployeeDao();
		Employee employee = null;
		try {
			employee = dao.checkName(username);
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
		return employee;
	}

	// �������еĴ��������û���Ϣ
	public List<Employee> ViewAllEmpAppr() {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = null;
		try {
			list = dao.ViewAllEmpAppr();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.closeConnection();
		}

		return list;
	}

	// �����û���Ϣ�ķ���
	public void approvraccount(String type, int empid) {
		EmployeeDao dao = new EmployeeDao();
		try {
			dao.approvraccount(type, empid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.closeConnection();
		}
	}

	// ͨ��ID��ԭ���룬��ѯ
	public Employee selectEmpByPwd(int employeeid, String oldpwd) {
		EmployeeDao dao = new EmployeeDao();
		Employee employee = null;
		try {
			employee = dao.selectByIdPwd(employeeid, oldpwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	// �޸�����
	public int changePwd(int employeeid, String newpwd) {
		EmployeeDao dao = new EmployeeDao();
		int flag = 0;
		try {
			flag = dao.changePwd(employeeid, newpwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// ����Ա��--��ҳ
	public void searchAllEmp(ResultPage<Employee> page, String employeename,
			String username, String status) {
		EmployeeDao dao = new EmployeeDao();
		try {
			int PageSize = 5; // ÿҳ������ʾ8��
			// ��ȡ����ҳ�б��������õ�PageResult�������list
			// ��ʼ������������ɣ���ҳ��-1��*ÿҳչ�ֵ�����
			int firstResult = (page.getCurrentPage() - 1) * PageSize;
			List<Employee> list;
			list = dao.selectEmpInfo(firstResult, PageSize, employeename,username, status);
			page.setList(list);
			
			// ��ȡ�������������ݣ��������õ�PageResult�������totalCount
			int totalNum = dao.getTotalNum(employeename, username, status);
			page.setTotalNum(totalNum);
			// �����������ҳ���������õ�PageResult�������totalPage
			// ������ҳ���ɣ�����������ÿҳ��ʾ���������������������+1.���û��������ֱ��ȡ�̡�
			int totalPage = totalNum % PageSize == 0 ? totalNum/PageSize:totalNum/PageSize+1;//��Ŀ�����
			page.setTotalPage(totalPage);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}

	}

	
	//ͨ������ID��ѯԱ����Ϣ
	public List<Employee> selectEmpByDept(int departmentid) {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = null;
		try {
			list = dao.selectEmpByDept(departmentid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		return list;
	}
	
}
