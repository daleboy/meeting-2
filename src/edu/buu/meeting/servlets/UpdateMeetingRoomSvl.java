package edu.buu.meeting.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.MeetingRoomBiz;
import edu.buu.meeting.entity.MeetingRoom;

/**
 *�޸Ļ�������Ϣ
 */
@WebServlet("/UpdateMeetingRoomSvl")
public class UpdateMeetingRoomSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UpdateMeetingRoomSvl() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roomid = Integer.parseInt(request.getParameter("roomid"));
		int roomnum = Integer.parseInt(request.getParameter("roomnum"));
		String roomname = request.getParameter("roomname");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		String status = request.getParameter("status");
		String description = request.getParameter("description");
		MeetingRoom room = new MeetingRoom(roomid, roomnum, roomname, capacity, status, description);
		MeetingRoomBiz biz = new MeetingRoomBiz();
		biz.updateMeetingRoom(room);
		request.getRequestDispatcher("AllMeetingRoomSvl").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
