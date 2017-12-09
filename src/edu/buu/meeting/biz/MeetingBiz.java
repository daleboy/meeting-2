package edu.buu.meeting.biz;

import java.sql.SQLException;
import java.util.List;

import edu.buu.meeting.dao.MeetingDao;
import edu.buu.meeting.entity.Employee;
import edu.buu.meeting.entity.Meeting;
import edu.buu.meeting.entity.SearchMeeting;

public class MeetingBiz {

	MeetingDao dao = new MeetingDao();

	//预定会议
	public void bookMeeting(Meeting meeting, List<Integer> employeeidlist) {
		int meetingid = 0;
		try {
			dao.beginTransaction(); //打开事务
			//插入数据，并返回meetingid
			meetingid = dao.insertMeetingInfo(meeting);
			//需要向会议参与者的表里添加多条数据，所有遍历参会参会人员id，循环插入数据
			for (Integer empid : employeeidlist) {
				dao.insertParticipantsInfo(meetingid, empid);
			}
			dao.commit();
		} catch (Exception e) {
			try {
				dao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			dao.closeConnection();
		}
	}

	//返回会议的详情，按会议信息查询
	public List<SearchMeeting> searchMeeting(String meetingname,
			String roomname, String reservername, String reservefromdate,
			String reservetodate, String meetingfromdate, String meetingtodate) {
		List<SearchMeeting> list = null;

		try {
			list = dao.searchMeeting(meetingname, roomname, reservername,
					reservefromdate, reservetodate, meetingfromdate,
					meetingtodate);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.closeConnection();
		}

		return list;
	}

	//返回会议详情，按会议ID查询
	public Meeting selectMeetingDetail(int meetingid) {
		Meeting meeting = null;
		try {
			meeting = dao.selectMeetingDetail(meetingid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meeting;
	}
	
	//返回会议参与人员
	public List<Employee> selectParticipants(int meetingid) {

		List<Employee> list = null;
		try {
			list = dao.selectParticipants(meetingid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			dao.closeConnection();
		}
		return list;
	}

	// 返回我的预定的会议信息
	public List<SearchMeeting> viewMeeting(int empid) {
		List<SearchMeeting> list = null;
		try {
			list = dao.viewMeeting(empid);

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dao.closeConnection();
		}
		return list;
	}
	
	// 返回我要参加的会议信息
	public List<SearchMeeting> viewMyMeeting(int empid) {
		List<SearchMeeting> list = null;
		try {
			list = dao.viewMyMeeting(empid);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dao.closeConnection();
		}
		return list;
	}

	//取消会议
	public void CancleMeeting(int meetingid) {
		try {
			dao.CancleMeeting(meetingid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			dao.closeConnection();
		}
		
	}
	
	
	// 返回我未来七天要参加的会议信息
	public List<SearchMeeting> viewMyFutureMeeting(int empid) {
		List<SearchMeeting> list = null;
		try {
			list = dao.viewMyFutureMeeting(empid);
		} catch (Exception e) {
			e.getStackTrace();
		} 
		return list;
	}
	
	// 返回我未来七天要参加但是取消了的会议信息
	public List<SearchMeeting> viewMyCancleMeeting(int empid) {
		List<SearchMeeting> list = null;
		try {
			list = dao.viewMyCancleMeeting(empid);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dao.closeConnection();
		}
		return list;
	}
	
}
