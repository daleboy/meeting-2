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
		String meetingname = request.getParameter("meetingname");//��������
		String roomname = request.getParameter("roomname");//����������
		String reservername = request.getParameter("reservername");//Ԥ��������
		String reservefromdate = request.getParameter("reservefromdate");//Ԥ����ʼʱ��
		String reservetodate = request.getParameter("reservetodate");//Ԥ������ʱ��
		String meetingfromdate = request.getParameter("meetingfromdate");//���鿪ʼʱ��
		String meetingtodate = request.getParameter("meetingtodate");//�������ʱ��

		MeetingBiz biz = new MeetingBiz();
		List<SearchMeeting>  list = biz.searchMeeting(meetingname,roomname,reservername,reservefromdate,reservetodate,meetingfromdate,meetingtodate);
		request.setAttribute("list",list);
		request.getRequestDispatcher("searchmeetings.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
