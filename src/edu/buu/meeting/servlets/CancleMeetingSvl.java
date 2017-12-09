package edu.buu.meeting.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.MeetingBiz;
/*
 * 取消会议
 * */
@WebServlet("/CancleMeetingSvl")
public class CancleMeetingSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CancleMeetingSvl() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int meetingid = Integer.parseInt(request.getParameter("meetingid"));
		MeetingBiz biz = new MeetingBiz();
		biz.CancleMeeting(meetingid);
		request.getRequestDispatcher("MyBookingSvl").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

