package edu.buu.meeting.entity;
/*
 * 部门实体类
 * */
public class Department {
	private int departmentid;
	private String departmentname;
	
	public Department(){
		
	}
	
	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname + "]";
	}
	
	
}
