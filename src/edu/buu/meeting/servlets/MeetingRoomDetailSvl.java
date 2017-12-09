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
 * 查看会议室详情
 */
@WebServlet("/MeetingRoomDetailSvl")
public class MeetingRoomDetailSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingRoomDetailSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		int roomid = Integer.parseInt(request.getParameter("roomid"));
		MeetingRoomBiz biz = new MeetingRoomBiz();
		MeetingRoom mRoom = biz.meetingRoomDetail(roomid);
		request.setAttribute("mroom",mRoom);
		System.out.println(mRoom);
		if(code.equals("allmr")){
			request.getRequestDispatcher("meetingroomdetail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
