package edu.buu.meeting.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.DepartmentBiz;
import edu.buu.meeting.entity.Department;

@WebServlet("/ViewDepartmentSvl")
public class ViewDepartmentSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewDepartmentSvl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = "";
		String cd = request.getParameter("code");
		if(cd != null&&!cd.equals("")){
			code = cd;
		}
		DepartmentBiz biz = new DepartmentBiz();// 创建Biz的对象
		List<Department> list = biz.selectAllDep();// 调用Biz的方法
		for (Department Department : list) {
			System.out.println(Department);
		}
		request.setAttribute("deplists", list);
		if(code.equals("register")){
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("departments.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
