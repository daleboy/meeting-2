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
		String oldpwd = request.getParameter("oldpwd");// ԭ����
		String newpwd = request.getParameter("newpwd");// ������
		String confirmnewpwd = request.getParameter("confirmnewpwd");// �ظ�������
		int employeeid = Integer.parseInt(request.getParameter("employeeid"));// ��ǰԱ��ID

		EmployeeBiz biz = new EmployeeBiz();
		Employee employee = null;

		// �ж����������Ƿ�Ϊ��
		if (oldpwd != null && !oldpwd.equals("") && newpwd != null
				&& !newpwd.equals("") && confirmnewpwd != null
				&& !confirmnewpwd.equals("")) {
			if (newpwd.equals(confirmnewpwd)) {
				employee = biz.selectEmpByPwd(employeeid, oldpwd);
				if (employee != null) {
					int flag = biz.changePwd(employeeid, newpwd);
					// �޸����룬���flagֵ��Ϊ0 ���޸ĳɹ�
					if (flag != 0) {
						msg="�����޸ĳɹ��������µ�¼";
						request.setAttribute("msg",msg);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					} else {
						msg="�����޸�ʧ��";
						request.setAttribute("msg",msg);
						request.getRequestDispatcher("changepassword.jsp").forward(request, response);
					}
				} else {
					msg="ԭ�����������";
					request.setAttribute("msg",msg);
					request.getRequestDispatcher("changepassword.jsp").forward(request, response);
				}
			} else {
				msg="�������������벻һ��";
				request.setAttribute("msg",msg);
				request.getRequestDispatcher("changepassword.jsp").forward(request, response);
			}
		} else {
			msg="����Ϊ��";
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("changepassword.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
