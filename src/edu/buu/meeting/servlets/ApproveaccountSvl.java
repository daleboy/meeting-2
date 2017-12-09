package edu.buu.meeting.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.EmployeeBiz;

/**
 *注册审批的功能
 */
@WebServlet("/ApproveaccountSvl")
public class ApproveaccountSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ApproveaccountSvl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String code = "";
	    String cd = request.getParameter("code");
	    if(cd!=null&&cd.equals("")){
	    	cd = code;
	    }
		String type = request.getParameter("type");
		int empid = Integer.parseInt(request.getParameter("employeeid"));
		EmployeeBiz biz = new EmployeeBiz();
		biz.approvraccount(type,empid);
		if(!code.equals("search")){
			request.getRequestDispatcher("SearchAllEmpSvl").forward(request, response);
		}else{
			request.getRequestDispatcher("ViewAllEmployeeApprSvl").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}