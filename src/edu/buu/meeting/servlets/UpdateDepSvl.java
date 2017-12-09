package edu.buu.meeting.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.DepartmentBiz;

@WebServlet("/UpdateDepSvl")
public class UpdateDepSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateDepSvl() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String depid = request.getParameter("departmentid");
		String depname = request.getParameter("departmentname");
		DepartmentBiz biz = new DepartmentBiz();
		biz.updateDep(Integer.parseInt(depid), depname);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
