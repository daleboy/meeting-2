package edu.buu.meeting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.buu.meeting.entity.MeetingRoom;

/*
 * 会议室的DAO层
 * */
public class MeetingRoomDao extends BaseDao {
	public List<MeetingRoom> allMeetingRoom() throws Exception{
		this.openConnection();
		String sql = "select * from meetingroom";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		MeetingRoom  mRoom = null;
		while(rs.next()){
			mRoom = new MeetingRoom();
			mRoom.setRoomid(rs.getInt("roomid"));
			mRoom.setRoomnum(rs.getInt("roomnum"));
			mRoom.setRoomname(rs.getString("roomname"));
			mRoom.setCapacity(rs.getInt("capacity"));
			mRoom.setStatus(rs.getString("status"));
			mRoom.setDescription(rs.getString("description"));
			list.add(mRoom);			
		}
		
		return list;
 		
	}
	//根据ID查找数据
	public MeetingRoom meetingRoomDetail(int roomid) throws Exception {
		this.openConnection();
		String sql = "select * from meetingroom where roomid=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, roomid);
		ResultSet rs = pst.executeQuery();
		MeetingRoom  mRoom = null;
		while(rs.next()){
			mRoom = new MeetingRoom();
			mRoom.setRoomid(rs.getInt("roomid"));
			mRoom.setRoomnum(rs.getInt("roomnum"));
			mRoom.setRoomname(rs.getString("roomname"));
			mRoom.setCapacity(rs.getInt("capacity"));
			mRoom.setStatus(rs.getString("status"));
			mRoom.setDescription(rs.getString("description"));
		}
		return mRoom;
	}
	
	//通过ID修改会议室信息
	public void updateMeetingRoom(MeetingRoom room) throws Exception {
		this.openConnection();
		String sqlupdate = "update meetingroom set roomnum=?,roomname=?,capacity=?,status=?,description=? where roomid=?";
		PreparedStatement pstupdate = conn.prepareStatement(sqlupdate);
		pstupdate.setInt(1, room.getRoomnum());
		pstupdate.setString(2, room.getRoomname());
		pstupdate.setInt(3, room.getCapacity());
		pstupdate.setString(4, room.getStatus());
		pstupdate.setString(5, room.getDescription());
		pstupdate.setInt(6, room.getRoomid());
		pstupdate.executeUpdate();
	}
	
	//查询此门牌号是否存在
	public MeetingRoom checkRoomNum(int roomnumber) throws Exception {
		this.openConnection();
		String sql = "select * from meetingroom where roomnum=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, roomnumber);
		ResultSet rs = pst.executeQuery();
		MeetingRoom  mRoom = null;
		while(rs.next()){
			mRoom = new MeetingRoom();
			mRoom.setRoomid(rs.getInt("roomid"));
			mRoom.setRoomnum(rs.getInt("roomnum"));
			mRoom.setRoomname(rs.getString("roomname"));
			mRoom.setCapacity(rs.getInt("capacity"));
			mRoom.setStatus(rs.getString("status"));
			mRoom.setDescription(rs.getString("description"));
		}
		return mRoom;
	}
	
	//插入会议室信息
	public void insertMeetingRoom(MeetingRoom room) throws Exception {
		this.openConnection();
		String sqlupdate = "insert into meetingroom(roomnum,roomname,capacity,status,description) values(?,?,?,?,?)";
		PreparedStatement pstupdate = conn.prepareStatement(sqlupdate);
		pstupdate.setInt(1, room.getRoomnum());
		pstupdate.setString(2, room.getRoomname());
		pstupdate.setInt(3, room.getCapacity());
		pstupdate.setString(4, room.getStatus());
		pstupdate.setString(5, room.getDescription());
		pstupdate.executeUpdate();
		
	}
}
