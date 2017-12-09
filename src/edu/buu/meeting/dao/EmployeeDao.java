package edu.buu.meeting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.buu.meeting.entity.Employee;

public class EmployeeDao extends BaseDao {
	// 插入一条数据
	public int insertEmpinfo(Employee employee) throws Exception {
		this.openConnection();
		String sql = "insert into employee(employeename,username,phone,email,status,departmentid,password,role) value(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, employee.getEmployeename());
		pst.setString(2, employee.getUsername());
		pst.setString(3, employee.getPhone());
		pst.setString(4, employee.getEmail());
		pst.setString(5, employee.getStatus());
		pst.setInt(6, employee.getDepartmentid());
		pst.setString(7, employee.getPassword());
		pst.setString(8, employee.getRole());
		pst.execute();// 执行语句
		return pst.getUpdateCount();
	}

	// 查询一条数据
	public Employee employee(String username) throws Exception {
		this.openConnection();
		String sql = "select * from employee where username=?";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setUsername(rs.getString("username"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			employee.setStatus(rs.getString("status"));
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setPassword(rs.getString("password"));
			employee.setRole(rs.getString("role"));
		}
		return employee;// 返回一个集合，需要修改返回值类型
	}

	// 根据用户ID查询数据
	public Employee selectById(int employeeid) throws Exception {
		this.openConnection();
		String sql = "select * from employee where employeeid=?";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		pst.setInt(1, employeeid);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setUsername(rs.getString("username"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			employee.setStatus(rs.getString("status"));
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setPassword(rs.getString("password"));
			employee.setRole(rs.getString("role"));
		}
		return employee;// 返回一个集合，需要修改返回值类型
	}

	// 查询登录情况
	public Employee selectByLogin(String username, String password)
			throws Exception {
		this.openConnection();
		String sql = "select * from employee where username=? and password=?";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setUsername(rs.getString("username"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			employee.setStatus(rs.getString("status"));
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setPassword(rs.getString("password"));
			employee.setRole(rs.getString("role"));
		}
		return employee;// 返回一个集合，需要修改返回值类型
	}

	// 查询一个表的数据
	public List<Employee> selectAll() throws Exception {
		this.openConnection();
		String sql = "select * from employee";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		ResultSet rs = pst.executeQuery();
		List<Employee> list = new ArrayList<Employee>();// 创建一个集合对象来接收数据列表
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setUsername(rs.getString("username"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			employee.setStatus(rs.getString("status"));
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setPassword(rs.getString("password"));
			employee.setRole(rs.getString("role"));
			list.add(employee);// 每条数据都存储到list集合里
		}
		return list;// 返回一个集合，需要修改返回值类型
	}

	// 删除一条数据
	public int deleteById(int employeeid) throws Exception {
		this.openConnection();
		String sqldel = "delete from employee where employeeid=?";
		PreparedStatement pstdel = conn.prepareStatement(sqldel);
		pstdel.setInt(1, employeeid);
		int num = pstdel.executeUpdate();
		return num;
	}

	// 修改一条信息
	public int updateById(String employeename, String username, String phone,
			String email, String status, int departmentid, String password,
			String role, int employeeid) throws Exception {
		this.openConnection();
		String sqlupdate = "update employee set employeename=?,username=?,phone=?,email=?,status=?,departmentid=?,password=?,role=? where employeeid=?";
		PreparedStatement pstupdate = conn.prepareStatement(sqlupdate);
		pstupdate.setString(1, employeename);
		pstupdate.setString(2, username);
		pstupdate.setString(3, phone);
		pstupdate.setString(4, email);
		pstupdate.setString(5, status);
		pstupdate.setInt(6, departmentid);
		pstupdate.setString(7, password);
		pstupdate.setString(8, role);
		pstupdate.setInt(9, employeeid);
		int num = pstupdate.executeUpdate();
		return num;
	}

	// 验证用户名是否存在，返回则数据存在，否则不存在
	public Employee checkName(String username) throws Exception {
		this.openConnection();
		String sql = "select * from employee where username=?";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setUsername(rs.getString("username"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			employee.setStatus(rs.getString("status"));
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setPassword(rs.getString("password"));
			employee.setRole(rs.getString("role"));
		}
		return employee;
	}

	// 返回所有的待审批的用户信息
	public List<Employee> ViewAllEmpAppr() throws Exception {
		this.openConnection();
		String sql = "select * from employee where status = ?";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		pst.setString(1, "0");
		ResultSet rs = pst.executeQuery();
		List<Employee> list = new ArrayList<Employee>();// 创建一个集合对象来接收数据列表
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setUsername(rs.getString("username"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			employee.setStatus(rs.getString("status"));
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setPassword(rs.getString("password"));
			employee.setRole(rs.getString("role"));
			list.add(employee);// 每条数据都存储到list集合里
		}
		return list;// 返回一个集合，需要修改返回值类型

	}

	// 审批用户注册的方法，如果type=“yes",那么状态值改为1.否则改为2
	public void approvraccount(String type, int empid) throws Exception {
		this.openConnection();
		String sqlupdate = null;
		if (type.equals("yes")) {
			sqlupdate = "update employee set status=1 where employeeid=?";
		} else {
			sqlupdate = "update employee set status=2 where employeeid=?";
		}
		PreparedStatement pstupdate = conn.prepareStatement(sqlupdate);
		pstupdate.setInt(1, empid);
		pstupdate.executeUpdate();

	}

	//通过ID和原密码查询数据
	public Employee selectByIdPwd(int employeeid, String oldpwd) throws Exception {
		this.openConnection();
		String sql = "select * from employee where employeeid=? and password=?";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		pst.setInt(1, employeeid);
		pst.setString(2, oldpwd);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setUsername(rs.getString("username"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			employee.setStatus(rs.getString("status"));
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setPassword(rs.getString("password"));
			employee.setRole(rs.getString("role"));
		}
		return employee;// 返回一个集合，需要修改返回值类型
	}
	//修改密码
	public int changePwd(int employeeid, String newpwd) throws Exception {
		this.openConnection();
		String sqlchange = "update employee set password=? where employeeid=?";
		PreparedStatement pstchange = conn.prepareStatement(sqlchange);
		pstchange.setString(1, newpwd);
		pstchange.setInt(2, employeeid);
		int num = pstchange.executeUpdate();
		return num;
	}
	
	
	//搜索员工分页查询
	public List<Employee> selectEmpInfo(int first,int PageSize,String employeename,String username,String status ) throws Exception{
		this.openConnection();
		String employeenamesql = "",usernamesql = "",statussql = "";
		if(employeename!=null && !employeename.equals("")){
			employeenamesql = "and employeename='"+employeename+"'";
		}
		if(username!=null && !username.equals("")){
			usernamesql = " and username ='"+username+"'";
		}
		if(status!=null && !status.equals("")&&!status.equals("3")){
			statussql = " and status ='"+status+"'";
		}
		String sql = "select * from employee where 1=1 "+employeenamesql+usernamesql+statussql+"limit?,?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, first);
		pst.setInt(2, PageSize);
		ResultSet rs = pst.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		Employee employee= null;
		while(rs.next()){
			employee = new Employee();
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setUsername(rs.getString("username"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			employee.setStatus(rs.getString("status"));
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setPassword(rs.getString("password"));
			employee.setRole(rs.getString("role"));
			list.add(employee);
		}
		return list;
	}
	//搜索员工--符合条件的一共有多少条数
	public int getTotalNum(String employeename,String username,String status ) throws Exception{
		this.openConnection();
		int totalnum = 0;
		String employeenamesql = "",usernamesql = "",statussql = "";
		if(employeename!=null && !employeename.equals("")){
			employeenamesql = "and employeename='"+employeename+"'";
		}
		if(username!=null && !username.equals("")){
			usernamesql = " and username ='"+username+"'";
		}
		if(status!=null && !status.equals("")&&!status.equals("3")){
			statussql = " and status ='"+status+"'";
		}
		String sql = "select count(*) from employee where 1=1 "+employeenamesql+usernamesql+statussql;
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			totalnum=rs.getInt(1);			
		}
		return totalnum;
		
	}
	//通过部门ID查询员工信息
	public List<Employee> selectEmpByDept(int departmentid) throws Exception {
		this.openConnection();
		String sql = "select * from employee where departmentid = ?";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		pst.setInt(1, departmentid);
		ResultSet rs = pst.executeQuery();
		List<Employee> list = new ArrayList<Employee>();// 创建一个集合对象来接收数据列表
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			list.add(employee);// 每条数据都存储到list集合里
		}
		return list;// 返回一个集合，需要修改返回值类型
	}
}
