package edu.buu.meeting.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.DepartmentBiz;

@WebServlet("/DeleteDepSvl")
public class DeleteDepSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteDepSvl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departmentid = request.getParameter("departmentid");
		DepartmentBiz biz = new DepartmentBiz();
		biz.deleteDep(Integer.parseInt(departmentid));
		request.getRequestDispatcher("ViewDepartmentSvl?code=departments").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
