package edu.buu.meeting.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.EmployeeBiz;
import edu.buu.meeting.entity.Employee;

/**
 * 返回所有的待审批用户信息
 */
@WebServlet("/ViewAllEmployeeApprSvl")
public class ViewAllEmployeeApprSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ViewAllEmployeeApprSvl() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeBiz biz = new EmployeeBiz();
		List<Employee> emplists = biz.ViewAllEmpAppr();
		System.out.println(emplists);//test
		request.setAttribute("emplists", emplists);
		request.getRequestDispatcher("approveaccount.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
