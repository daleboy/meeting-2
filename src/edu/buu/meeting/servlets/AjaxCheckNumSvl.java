package edu.buu.meeting.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.buu.meeting.biz.MeetingRoomBiz;
import edu.buu.meeting.entity.MeetingRoom;

@WebServlet("/AjaxCheckNumSvl")
public class AjaxCheckNumSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxCheckNumSvl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roomnumber = Integer.parseInt(request.getParameter("roomnumber"));
		MeetingRoomBiz biz = new MeetingRoomBiz();
		MeetingRoom room = biz.checkRoomNum(roomnumber);
		PrintWriter out = response.getWriter();
		//֤���鵽���ݣ��޷�ʹ�ô����ƺţ�����1�����Ϊ�գ�����ʹ�ã�����0
		if(room!=null){
			out.print("1");
		}else{
			out.print("0");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
