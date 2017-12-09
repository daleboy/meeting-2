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
	 * get��ʽ����������ʾ�ڵ�ַ���� post��ʽ�������ݲ���ʾ�ڵ�ַ��
	 * servlet:�̳�HttpServlet,��������jspҳ����������ݣ��������ݴ������ͬ�Ľ����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getParameter����Ĳ���һ��Ҫ��jsp�е�formһ��
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "   " + password);

		// �ж��ʻ��������Ƿ�Ϊ��
		if (username != null && !username.equals("") && password != null && !password.equals("")) {
			EmployeeBiz biz = new EmployeeBiz();// ����ҵ���߼���biz��Ķ���
			int flag = biz.login(username, password);// ����Biz���е�login����
			if (flag == 1) {
				//����Biz����������employee���������
				Employee e = biz.getEmployeeInfo();
				HttpSession session  = request.getSession();//����Session����
				session.setAttribute("employeename",e.getEmployeename());//�Ự����
				session.setAttribute("employeeid",e.getEmployeeid());//��Ա��ID����session��
				// �ڵ�¼�ɹ�������£��ж��û���ɫ��ֵ��1����Ա��2��ͨ�û�
				if (e.getRole().equals("1")) {
					request.getRequestDispatcher("adminindex.jsp").forward(request,response);
				} else {
					request.getRequestDispatcher("employeeindex.jsp").forward(request,response);
				}
			} else {
				if (flag == 0) {
					msg = "�ȴ����";
				} else if (flag == 2) {
					msg = "���δͨ��";
				} else {
					msg = "�ʻ����������";
				}
				//�����������ԣ�Ҳ���Ƿ��ش�����Ϣ
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}

		} else {
			request.setAttribute("msg", "�û������벻��Ϊ�գ�");
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
