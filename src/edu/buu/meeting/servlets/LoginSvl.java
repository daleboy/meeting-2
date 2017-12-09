package edu.buu.meeting.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.buu.meeting.biz.EmployeeBiz;
import edu.buu.meeting.entity.Employee;

/**
 * Servlet implementation class LoginSvl
 */
@WebServlet("/LoginSvl")
public class LoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String msg;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * get方式请求：内容显示在地址栏中 post方式请求：内容不显示在地址栏
	 * servlet:继承HttpServlet,用来接收jsp页面请求的数据，根据数据处理出不同的结果。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getParameter里面的参数一定要和jsp中的form一致
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "   " + password);

		// 判断帐户名密码是否为空
		if (username != null && !username.equals("") && password != null && !password.equals("")) {
			EmployeeBiz biz = new EmployeeBiz();// 创建业务逻辑层biz层的对象
			int flag = biz.login(username, password);// 调用Biz层中的login方法
			if (flag == 1) {
				//调用Biz方法，返回employee对象的数据
				Employee e = biz.getEmployeeInfo();
				HttpSession session  = request.getSession();//创建Session对象
				session.setAttribute("employeename",e.getEmployeename());//会话属性
				session.setAttribute("employeeid",e.getEmployeeid());//把员工ID存在session里
				// 在登录成功的情况下：判断用户角色的值。1管理员，2普通用户
				if (e.getRole().equals("1")) {
					request.getRequestDispatcher("adminindex.jsp").forward(request,response);
				} else {
					request.getRequestDispatcher("employeeindex.jsp").forward(request,response);
				}
			} else {
				if (flag == 0) {
					msg = "等待审核";
				} else if (flag == 2) {
					msg = "审核未通过";
				} else {
					msg = "帐户名密码错误";
				}
				//设置请求属性，也就是返回错误信息
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}

		} else {
			request.setAttribute("msg", "用户名密码不能为空！");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		System.out.println(msg);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
