package edu.buu.meeting.entity;

public class MeetingRoom {
	private int roomid;
	private int roomnum;
	private String roomname;
	private int capacity;
	private String status;
	private String description;
	
	public MeetingRoom() {

	}
	public MeetingRoom(int roomnum, String roomname, int capacity,
			String status, String description) {
		super();
		this.roomnum = roomnum;
		this.roomname = roomname;
		this.capacity = capacity;
		this.status = status;
		this.description = description;
	}
	
	//ȫ�������Ĺ��췽��
	public MeetingRoom(int roomid, int roomnum, String roomname, int capacity,
			String status, String description) {
		super();
		this.roomid = roomid;
		this.roomnum = roomnum;
		this.roomname = roomname;
		this.capacity = capacity;
		this.status = status;
		this.description = description;
	}

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Meetingroom [roomid=" + roomid + ", roomnum=" + roomnum
				+ ", roomname=" + roomname + ", capacity=" + capacity
				+ ", status=" + status + ", description=" + description + "]";
	}
	
	
	
}
