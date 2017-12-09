package edu.buu.meeting.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.EmployeeBiz;
import edu.buu.meeting.entity.Employee;
/*注册用户信息*/
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
		int departmentid = Integer.parseInt(request.getParameter("departmentid"));//接收到的是String类型，需要类型转换
		Employee employee = new Employee(employeename, username, phone, email, "0", departmentid, password, "2");//调用多参数的构造方法，status、role默认0，2
		EmployeeBiz biz = new EmployeeBiz();
		int flag =biz.Register(employee);//调用Biz层的注册方法，参数是一个employee对象
		
		if(flag != 1){
			request.setAttribute("msg","注册成功，请等待审核");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("msg","注册失败，用户名已存在，请重新注册");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
