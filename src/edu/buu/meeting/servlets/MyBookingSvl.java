package edu.buu.meeting.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.buu.meeting.biz.MeetingBiz;
import edu.buu.meeting.entity.SearchMeeting;

/**
 * 我的预定--列表
 */

@WebServlet("/MyBookingSvl")
public class MyBookingSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyBookingSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MeetingBiz biz = new MeetingBiz();
		HttpSession session = request.getSession();
		int empid = (Integer) session.getAttribute("employeeid");
		List<SearchMeeting> list = biz.viewMeeting(empid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("mybookings.jsp").forward(request,response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
