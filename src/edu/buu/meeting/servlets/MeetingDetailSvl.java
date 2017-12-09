package edu.buu.meeting.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.MeetingBiz;
import edu.buu.meeting.entity.Employee;
import edu.buu.meeting.entity.Meeting;

/**
 * 会议详情
 */
@WebServlet("/MeetingDetailSvl")
public class MeetingDetailSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingDetailSvl() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String code = "";
		String cd = request.getParameter("code");
		if (cd != null && !cd.equals("")) {
			code = cd;
		}
		int meetingid = Integer.parseInt(request.getParameter("meetingid"));
		MeetingBiz biz = new MeetingBiz();
		Meeting meeting = biz.selectMeetingDetail(meetingid);
		List<Employee> list  = biz.selectParticipants(meetingid);
		request.setAttribute("meeting", meeting);//会议信息
		request.setAttribute("list", list);//参会人员
		if (code.equals("search")) {
			request.getRequestDispatcher("meetingdetails.jsp").forward(request,response);
		} else if(code.equals("book")) {
			request.getRequestDispatcher("mybookingdetail.jsp").forward(request, response);
		} else if(code.equals("mymeet")) {
			request.getRequestDispatcher("mymeetingdetails.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
