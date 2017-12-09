package edu.buu.meeting.biz;

import java.sql.SQLException;
import java.util.List;

import edu.buu.meeting.dao.MeetingDao;
import edu.buu.meeting.entity.Employee;
import edu.buu.meeting.entity.Meeting;
import edu.buu.meeting.entity.SearchMeeting;

public class MeetingBiz {

	MeetingDao dao = new MeetingDao();

	//Ԥ������
	public void bookMeeting(Meeting meeting, List<Integer> employeeidlist) {
		int meetingid = 0;
		try {
			dao.beginTransaction(); //������
			//�������ݣ�������meetingid
			meetingid = dao.insertMeetingInfo(meeting);
			//��Ҫ���������ߵı�����Ӷ������ݣ����б����λ�λ���Աid��ѭ����������
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

	//���ػ�������飬��������Ϣ��ѯ
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

	//���ػ������飬������ID��ѯ
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
	
	//���ػ��������Ա
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

	// �����ҵ�Ԥ���Ļ�����Ϣ
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
	
	// ������Ҫ�μӵĻ�����Ϣ
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

	//ȡ������
	public void CancleMeeting(int meetingid) {
		try {
			dao.CancleMeeting(meetingid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			dao.closeConnection();
		}
		
	}
	
	
	// ������δ������Ҫ�μӵĻ�����Ϣ
	public List<SearchMeeting> viewMyFutureMeeting(int empid) {
		List<SearchMeeting> list = null;
		try {
			list = dao.viewMyFutureMeeting(empid);
		} catch (Exception e) {
			e.getStackTrace();
		} 
		return list;
	}
	
	// ������δ������Ҫ�μӵ���ȡ���˵Ļ�����Ϣ
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
