package edu.buu.meeting.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.EmployeeBiz;
import edu.buu.meeting.entity.Employee;

@WebServlet("/ChangePwdSvl")
public class ChangePwdSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String msg;

	public ChangePwdSvl() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String oldpwd = request.getParameter("oldpwd");// 原密码
		String newpwd = request.getParameter("newpwd");// 新密码
		String confirmnewpwd = request.getParameter("confirmnewpwd");// 重复新密码
		int employeeid = Integer.parseInt(request.getParameter("employeeid"));// 当前员工ID

		EmployeeBiz biz = new EmployeeBiz();
		Employee employee = null;

		// 判断三个参数是否为空
		if (oldpwd != null && !oldpwd.equals("") && newpwd != null
				&& !newpwd.equals("") && confirmnewpwd != null
				&& !confirmnewpwd.equals("")) {
			if (newpwd.equals(confirmnewpwd)) {
				employee = biz.selectEmpByPwd(employeeid, oldpwd);
				if (employee != null) {
					int flag = biz.changePwd(employeeid, newpwd);
					// 修改密码，如果flag值不为0 则修改成功
					if (flag != 0) {
						msg="密码修改成功，请重新登录";
						request.setAttribute("msg",msg);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					} else {
						msg="密码修改失败";
						request.setAttribute("msg",msg);
						request.getRequestDispatcher("changepassword.jsp").forward(request, response);
					}
				} else {
					msg="原密码输入错误";
					request.setAttribute("msg",msg);
					request.getRequestDispatcher("changepassword.jsp").forward(request, response);
				}
			} else {
				msg="两次输入新密码不一致";
				request.setAttribute("msg",msg);
				request.getRequestDispatcher("changepassword.jsp").forward(request, response);
			}
		} else {
			msg="不能为空";
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("changepassword.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
