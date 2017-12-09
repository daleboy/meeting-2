package edu.buu.meeting.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.EmployeeBiz;
import edu.buu.meeting.entity.Employee;
/*验证用户名是否存在*/
@WebServlet("/CheckNameSvl")
public class CheckNameSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CheckNameSvl() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(username);
		EmployeeBiz biz = new EmployeeBiz();
		Employee employee = biz.checkName(username);
		//返回的数据如果为空，证明数据库中没有这条数据，可以注册，否则用户名重复
		PrintWriter out = response.getWriter();//ajax请求，返回结果写入到页面
		if(employee == null){
			out.print("success");
		}else{
			out.print("fail");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
