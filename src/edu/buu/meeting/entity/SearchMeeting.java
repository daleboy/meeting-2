package edu.buu.meeting.entity;

import java.sql.Timestamp;

/*
 *�������� 
 * */
public class SearchMeeting {
	private int meetingid;//����ID
	private String meetingname;//��������
	private String roomname;//����������
	private Timestamp starttime;//���鿪ʼʱ��
	private Timestamp endtime;//�������ʱ��
	private Timestamp reservationtime;//����Ԥ��ʱ��
	private String employeename;//Ԥ��Ա������
	private String status;//����״̬
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}
	public String getMeetingname() {
		return meetingname;
	}
	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	public Timestamp getReservationtime() {
		return reservationtime;
	}
	public void setReservationtime(Timestamp reservationtime) {
		this.reservationtime = reservationtime;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
	
	
}
