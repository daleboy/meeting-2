package edu.buu.meeting.biz;

import java.util.List;

import edu.buu.meeting.dao.EmployeeDao;
import edu.buu.meeting.entity.Employee;
import edu.buu.meeting.util.ResultPage;

public class EmployeeBiz {
	private Employee employee;
	EmployeeDao dao = new EmployeeDao();

	// 登录的方法
	public int login(String username, String password) {

		employee = null;
		int flag = 3;
		try {
			employee = dao.selectByLogin(username, password);
			// 用户名密码如果不正确，登录失败；如果正确，再看status，若status=1.则登录成功
			// flag=3用户名密码不正确，flag=1登录成功，flag=0注册过在审核中,flag=2注册过审核未通过
			if (employee != null) {
				String status = employee.getStatus();// 获取账户的状态
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

	// 注册新账户
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

	// 获取员工信息
	public Employee getEmployeeInfo() {
		return employee;
	}

	// 验证用户名是否存在
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

	// 返回所有的待审批的用户信息
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

	// 审批用户信息的方法
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

	// 通过ID和原密码，查询
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

	// 修改密码
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

	// 搜索员工--分页
	public void searchAllEmp(ResultPage<Employee> page, String employeename,
			String username, String status) {
		EmployeeDao dao = new EmployeeDao();
		try {
			int PageSize = 5; // 每页数据显示8条
			// 获取到分页列表，把他设置到PageResult对象里的list
			// 起始条数的运算规律：（页码-1）*每页展现的条数
			int firstResult = (page.getCurrentPage() - 1) * PageSize;
			List<Employee> list;
			list = dao.selectEmpInfo(firstResult, PageSize, employeename,username, status);
			page.setList(list);
			
			// 获取到共多少条数据，把他设置到PageResult对象里的totalCount
			int totalNum = dao.getTotalNum(employeename, username, status);
			page.setTotalNum(totalNum);
			// 换算出共多少页，把他设置到PageResult对象里的totalPage
			// 共多少页规律：总条数除以每页显示的条数，如果有余数，商+1.如果没有余数，直接取商。
			int totalPage = totalNum % PageSize == 0 ? totalNum/PageSize:totalNum/PageSize+1;//三目运算符
			page.setTotalPage(totalPage);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}

	}

	
	//通过部门ID查询员工信息
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
