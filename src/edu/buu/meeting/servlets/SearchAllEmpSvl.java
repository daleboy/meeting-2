package edu.buu.meeting.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.EmployeeBiz;
import edu.buu.meeting.entity.Employee;
import edu.buu.meeting.util.ResultPage;

@WebServlet("/SearchAllEmpSvl")
public class SearchAllEmpSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchAllEmpSvl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String employeename = request.getParameter("employeename");
	    String username = request.getParameter("username");
	    String status = request.getParameter("status");
		int currentPage = 1;//Ĭ����ʾ��һҳ
	    String curPage = request.getParameter("currentPage");
	    //���ȡ����curPage��Ϊ�վ�ת��Ϊint����
	    if(curPage!=null){
	    	currentPage = Integer.parseInt(curPage);
	    }
	    
	    //������ҳ������Ķ���
		ResultPage<Employee> page = new ResultPage<Employee>();
	    page.setCurrentPage(currentPage);
	    
	    EmployeeBiz biz = new EmployeeBiz();
	    biz.searchAllEmp(page, employeename, username, status);
	    request.setAttribute("page",page);
	    request.getRequestDispatcher("searchemployees.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
