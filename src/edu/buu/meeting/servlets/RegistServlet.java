package edu.buu.meeting.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.EmployeeBiz;
import edu.buu.meeting.entity.Employee;
/*ע���û���Ϣ*/
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistServlet() {
        super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeename = request.getParameter("employeename");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int departmentid = Integer.parseInt(request.getParameter("departmentid"));//���յ�����String���ͣ���Ҫ����ת��
		Employee employee = new Employee(employeename, username, phone, email, "0", departmentid, password, "2");//���ö�����Ĺ��췽����status��roleĬ��0��2
		EmployeeBiz biz = new EmployeeBiz();
		int flag =biz.Register(employee);//����Biz���ע�᷽����������һ��employee����
		
		if(flag != 1){
			request.setAttribute("msg","ע��ɹ�����ȴ����");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("msg","ע��ʧ�ܣ��û����Ѵ��ڣ�������ע��");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
