package edu.buu.meeting.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.EmployeeBiz;
import edu.buu.meeting.entity.Employee;

/**
 * 根据部门ID查询所有员工
 */
@WebServlet("/SelectEmployeesOfDeptSvl")
public class SelectEmployeesOfDeptSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectEmployeesOfDeptSvl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int departmentid = Integer.parseInt(request.getParameter("departmentid"));
		EmployeeBiz biz = new EmployeeBiz();
		List<Employee> list = biz.selectEmpByDept(departmentid);

		//将查询得到的员工信息，以XML文档的格式返回到浏览器
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control", "no-cache");
		out.println("<?xml version='1.0' encoding='"+"utf-8"+"'?>");
		
		//符合XML规范，有根节点，否则解析有问题
		out.println("<employees>");
		for(Employee e:list){
			out.println("<option>");
			out.println("<value>"+e.getEmployeeid()+"</value>");
			out.println("<text>"+e.getEmployeename()+"</text>");
			out.println("</option>");
		}
		out.println("</employees>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
