package edu.buu.meeting.biz;

import java.util.List;

import edu.buu.meeting.dao.MeetingRoomDao;
import edu.buu.meeting.entity.MeetingRoom;

/*
 * ҵ���߼���
 * */
public class MeetingRoomBiz {

	public List<MeetingRoom> allMeetingRoom() {
		MeetingRoomDao dao = new MeetingRoomDao();
		List<MeetingRoom> list = null;
		try {
			list = dao.allMeetingRoom();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		
		return list;
	}
	//�鿴����������
	public MeetingRoom meetingRoomDetail(int roomid) {
		MeetingRoomDao dao = new MeetingRoomDao();
		MeetingRoom room = null;
		try {
			room = dao.meetingRoomDetail(roomid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		
		return room;
	}
	
	//�޸Ļ�������Ϣ
	public void updateMeetingRoom(MeetingRoom room) {
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			dao.updateMeetingRoom(room);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		
	}
	
	//����Ƿ�Ϊ��
	public MeetingRoom checkRoomNum(int roomnumber) {
		MeetingRoomDao dao = new MeetingRoomDao();
		MeetingRoom room = null;
		try {
			room = dao.checkRoomNum(roomnumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		return room;
	}
	
	//�����������Ϣ
	public void insertMeetingRoom(MeetingRoom room) {
		MeetingRoomDao dao = new MeetingRoomDao();
		try {
			dao.insertMeetingRoom(room);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection();
		}
		
		
	}
	

}
