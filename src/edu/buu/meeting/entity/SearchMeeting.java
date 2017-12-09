package edu.buu.meeting.entity;

import java.sql.Timestamp;

/*
 *搜索会议 
 * */
public class SearchMeeting {
	private int meetingid;//会议ID
	private String meetingname;//会议名称
	private String roomname;//会议室名称
	private Timestamp starttime;//会议开始时间
	private Timestamp endtime;//会议结束时间
	private Timestamp reservationtime;//会议预定时间
	private String employeename;//预定员工姓名
	private String status;//会议状态
	
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
