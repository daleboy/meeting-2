package edu.buu.meeting.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.MeetingRoomBiz;
import edu.buu.meeting.entity.MeetingRoom;

@WebServlet("/AllMeetingRoomSvl")
public class AllMeetingRoomSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AllMeetingRoomSvl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingRoomBiz biz = new MeetingRoomBiz();
		List<MeetingRoom> list = biz.allMeetingRoom();
		request.setAttribute("mrlists", list);
		System.out.println(list);
		request.getRequestDispatcher("allmeetingrooms.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
