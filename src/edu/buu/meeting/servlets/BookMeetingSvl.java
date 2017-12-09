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
 * Ԥ������
 */
@WebServlet("/BookMeetingSvl")
public class BookMeetingSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookMeetingSvl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		//code==prepare��Ҫ��ѯ׼�������ݣ�code==book��ҪԤ������Ĳ���
		if(code!=null&&code.equals("prepare")){
			MeetingRoomBiz mbiz = new MeetingRoomBiz();
			DepartmentBiz dbiz = new DepartmentBiz();
			
			List<MeetingRoom> mList = mbiz.allMeetingRoom();
			List<Department> dList = dbiz.selectAllDep();
			
			request.setAttribute("roomsList", mList);
			request.setAttribute("deptsList", dList);
			
			request.getRequestDispatcher("bookmeeting.jsp").forward(request, response);
			
		}
		//Ԥ��������Ϣ�ύ����servlet
		if(code!=null&&code.equals("book")){
			String meetingname = request.getParameter("meetingname");//��������
			int roomid = Integer.parseInt(request.getParameter("roomid"));//�����ұ�ʶ
			HttpSession session = request.getSession();
			int reservationistid = (Integer)session.getAttribute("employeeid");//Ԥ���߱�ʶ��Ҳ���ǵ�ǰ��½ID
			int numberofparticipants = Integer.parseInt(request.getParameter("numofparticipants"));//�λ���Ա����
			
			Timestamp starttime = Timestamp.valueOf(request.getParameter("starttime"));//��ʼʱ��
			Timestamp endtime = Timestamp.valueOf(request.getParameter("endtime"));//����ʱ��
			Timestamp canceledtime = null;//ȡ��ʱ��
			Timestamp reservationtime = new Timestamp(System.currentTimeMillis());//Ԥ��ʱ��---��ȡ��ǰʱ��
			
			String description = request.getParameter("description");//��������
			String status ="0";// ״̬Ĭ��Ϊ����
			
			Meeting meeting = new Meeting(meetingname, roomid, reservationistid, numberofparticipants, starttime, endtime, reservationtime, canceledtime, description, status);
			//���вλ���ԱID
			String[] ary = request.getParameterValues("selSelectedEmployees");
			
			List<Integer> employeelist = new ArrayList<Integer>();
			
			//�������вλ���Ա��ID����String����ת��ΪINT����
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
