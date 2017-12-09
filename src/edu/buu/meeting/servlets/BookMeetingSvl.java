package edu.buu.meeting.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.buu.meeting.biz.DepartmentBiz;
import edu.buu.meeting.biz.MeetingBiz;
import edu.buu.meeting.biz.MeetingRoomBiz;
import edu.buu.meeting.entity.Department;
import edu.buu.meeting.entity.Meeting;
import edu.buu.meeting.entity.MeetingRoom;

/**
 * 预定会议
 */
@WebServlet("/BookMeetingSvl")
public class BookMeetingSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookMeetingSvl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		//code==prepare是要查询准备的数据，code==book是要预定会议的操作
		if(code!=null&&code.equals("prepare")){
			MeetingRoomBiz mbiz = new MeetingRoomBiz();
			DepartmentBiz dbiz = new DepartmentBiz();
			
			List<MeetingRoom> mList = mbiz.allMeetingRoom();
			List<Department> dList = dbiz.selectAllDep();
			
			request.setAttribute("roomsList", mList);
			request.setAttribute("deptsList", dList);
			
			request.getRequestDispatcher("bookmeeting.jsp").forward(request, response);
			
		}
		//预定会议信息提交表单的servlet
		if(code!=null&&code.equals("book")){
			String meetingname = request.getParameter("meetingname");//会议名称
			int roomid = Integer.parseInt(request.getParameter("roomid"));//会议室标识
			HttpSession session = request.getSession();
			int reservationistid = (Integer)session.getAttribute("employeeid");//预订者标识，也就是当前登陆ID
			int numberofparticipants = Integer.parseInt(request.getParameter("numofparticipants"));//参会人员个数
			
			Timestamp starttime = Timestamp.valueOf(request.getParameter("starttime"));//开始时间
			Timestamp endtime = Timestamp.valueOf(request.getParameter("endtime"));//结束时间
			Timestamp canceledtime = null;//取消时间
			Timestamp reservationtime = new Timestamp(System.currentTimeMillis());//预定时间---获取当前时间
			
			String description = request.getParameter("description");//会议描述
			String status ="0";// 状态默认为正常
			
			Meeting meeting = new Meeting(meetingname, roomid, reservationistid, numberofparticipants, starttime, endtime, reservationtime, canceledtime, description, status);
			//所有参会人员ID
			String[] ary = request.getParameterValues("selSelectedEmployees");
			
			List<Integer> employeelist = new ArrayList<Integer>();
			
			//遍历所有参会人员的ID，把String类型转换为INT类型
			for(String s:ary){
				employeelist.add(Integer.parseInt(s));
			}
			
			MeetingBiz biz = new MeetingBiz();
			biz.bookMeeting(meeting,employeelist);
			request.getRequestDispatcher("SearchMeetingSvl").forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
