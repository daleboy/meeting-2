package edu.buu.meeting.entity;

/*
 * 员工实体类
 * 
 * */
public class Employee {
	private int employeeid;// 员工标识
	private String employeename;// 员工姓名
	private String username;// 用户名
	private String phone;// 电话
	private String email;// 电子邮件
	private String status;// 审批状态,0待审批,1审批通过,2审批未通过
	private int departmentid;// 部门ID
	private String password;// 密码
	private String role;// 用户角色

	public Employee() {

	}
	//除了ID之外的构造方法
	public Employee(String employeename, String username, String phone,
			String email, String status, int departmentid, String password,
			String role) {
		super();
		this.employeename = employeename;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.departmentid = departmentid;
		this.password = password;
		this.role = role;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String status() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", username=" + username
				+ ", phone=" + phone + ", email=" + email + ", status=" + status + ", departmentid=" + departmentid
				+ ", password=" + password + ", role=" + role + "]";
	}
}
