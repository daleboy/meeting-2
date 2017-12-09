package edu.buu.meeting.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.MeetingBiz;
import edu.buu.meeting.entity.SearchMeeting;

/**
 * Servlet implementation class SearchMeetingSvl
 */
@WebServlet("/SearchMeetingSvl")
public class SearchMeetingSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchMeetingSvl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String meetingname = request.getParameter("meetingname");//会议名称
		String roomname = request.getParameter("roomname");//会议室名称
		String reservername = request.getParameter("reservername");//预订者姓名
		String reservefromdate = request.getParameter("reservefromdate");//预定开始时间
		String reservetodate = request.getParameter("reservetodate");//预定结束时间
		String meetingfromdate = request.getParameter("meetingfromdate");//会议开始时间
		String meetingtodate = request.getParameter("meetingtodate");//会议结束时间

		MeetingBiz biz = new MeetingBiz();
		List<SearchMeeting>  list = biz.searchMeeting(meetingname,roomname,reservername,reservefromdate,reservetodate,meetingfromdate,meetingtodate);
		request.setAttribute("list",list);
		request.getRequestDispatcher("searchmeetings.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
