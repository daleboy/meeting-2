package edu.buu.meeting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.buu.meeting.entity.Employee;
import edu.buu.meeting.entity.Meeting;
import edu.buu.meeting.entity.SearchMeeting;

public class MeetingDao extends BaseDao {
	// 插入所有会议信息，并且返回插入的meetingid
	public int insertMeetingInfo(Meeting meeting) throws Exception {
		int meetingid = 0;
		this.openConnection();
		String sql = "insert into Meeting(meetingname,roomid,reservationistid,numberofparticipants,starttime,endtime,reservationtime,description,status) value(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, meeting.getMeetingname());
		pst.setInt(2, meeting.getRoomid());
		pst.setInt(3, meeting.getReservationistid());
		pst.setInt(4, meeting.getNumberofparticipants());
		pst.setTimestamp(5, meeting.getStarttime());
		pst.setTimestamp(6, meeting.getEndtime());
		pst.setTimestamp(7, meeting.getReservationtime());
		pst.setString(8, meeting.getDescription());
		pst.setString(9, meeting.getStatus());
		pst.executeUpdate();// 执行语句
		ResultSet rs = pst.executeQuery("select max(meetingid) from meeting");
		while (rs.next()) {
			meetingid = rs.getInt(1);
		}
		return meetingid;
	}

	// 查询一条数据
	public Meeting selectById(int meetingid) throws Exception {
		this.openConnection();
		String sql = "select * from meeting where meetingid=?";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		pst.setInt(1, meetingid);
		ResultSet rs = pst.executeQuery();
		Meeting Meeting = null;
		while (rs.next()) {
			Meeting = new Meeting();
			Meeting.setMeetingname(rs.getString("Meetingname"));
			Meeting.setRoomid(rs.getInt("roomid"));
			Meeting.setReservationistid(rs.getInt("reservationistid"));
			Meeting.setNumberofparticipants(rs.getInt("numberofparticipants"));
			Meeting.setStarttime(rs.getTimestamp("starttime"));
			Meeting.setEndtime(rs.getTimestamp("endtime"));
			Meeting.setReservationtime(rs.getTimestamp("reservationtime"));
			Meeting.setCanceledtime(rs.getTimestamp("canceledtime"));
			Meeting.setDescription(rs.getString("description"));
			Meeting.setStatus(rs.getString("status"));
		}
		return Meeting;// 返回一个集合，需要修改返回值类型
	}

	// 查询一个表的数据
	public List<Meeting> selectAll() throws Exception {
		this.openConnection();
		String sql = "select * from meeting";
		PreparedStatement pst = conn.prepareStatement(sql);// 创建执行SQL语句的statement--使用PrepareStatement
		ResultSet rs = pst.executeQuery();
		List<Meeting> list = new ArrayList<Meeting>();// 创建一个集合对象来接收数据列表
		Meeting Meeting = null;
		while (rs.next()) {
			Meeting = new Meeting();
			Meeting.setMeetingname(rs.getString("Meetingname"));
			Meeting.setRoomid(rs.getInt("roomid"));
			Meeting.setReservationistid(rs.getInt("reservationistid"));
			Meeting.setNumberofparticipants(rs.getInt("numberofparticipants"));
			Meeting.setStarttime(rs.getTimestamp("starttime"));
			Meeting.setEndtime(rs.getTimestamp("endtime"));
			Meeting.setReservationtime(rs.getTimestamp("reservationtime"));
			Meeting.setCanceledtime(rs.getTimestamp("canceledtime"));
			Meeting.setDescription(rs.getString("description"));
			Meeting.setStatus(rs.getString("status"));
			list.add(Meeting);// 每条数据都存储到list集合里
		}
		return list;// 返回一个集合，需要修改返回值类型
	}

	// 删除一条数据
	public int deleteById(int Meetingid) throws Exception {
		this.openConnection();
		String sqldel = "delete from Meeting where Meetingid=?";
		PreparedStatement pstdel = conn.prepareStatement(sqldel);
		pstdel.setInt(1, Meetingid);
		int num = pstdel.executeUpdate();
		return num;
	}

	// 修改一条信息
	public int updateById(String Meetingname, int Meetingid) throws Exception {
		this.openConnection();
		String sqlupdate = "update Meeting set Meetingname=? where Meetingid=?";
		PreparedStatement pstupdate = conn.prepareStatement(sqlupdate);
		pstupdate.setString(1, Meetingname);
		pstupdate.setInt(2, Meetingid);
		int num = pstupdate.executeUpdate();
		return num;
	}
	
	
	//插入参会者会议信息
	public void insertParticipantsInfo(int meetingid, Integer empid)
			throws Exception {
		this.openConnection();
		String sql = "insert into meetingparticipants value(?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, meetingid);
		pst.setInt(2, empid);
		pst.executeUpdate();// 执行语句

	}

	// 根据搜索条件查询会议信息
	public List<SearchMeeting> searchMeeting(String meetingname,
			String roomname, String reservername, String reservefromdate,
			String reservetodate, String meetingfromdate, String meetingtodate)
			throws Exception {
		this.openConnection();
		String meetingnamesql = "", roomnamesql = "", reservernamesql = "";
		String reservedatesql = "", meetingdatesql = "";

		// 判断搜索条件会议名称是否为空，如果不为空，拼接此条件的SQL语句
		if (meetingname != null && !meetingname.equals("")) {
			meetingnamesql = "and meetingname ='" + meetingname + "'";
		}
		// 判断搜索条件会议室名称是否为空，如果不为空，拼接此条件的SQL语句
		if (roomname != null && !roomname.equals("")) {
			roomnamesql = "and roomname ='" + roomname + "'";
		}
		// 判断搜索条件预订者名称是否为空，如果不为空，拼接此条件的SQL语句-----也就是员工姓名
		if (reservername != null && !reservername.equals("")) {
			reservernamesql = "and employeename ='" + reservername + "'";
		}
		// 判断搜索条件--预定时间，搜索某个时间段内的预定时间
		if (reservefromdate != null && !reservefromdate.equals("")
				&& reservetodate != null && !reservetodate.equals("")) {
			reservedatesql = "and reservationtime BETWEEN'" + reservefromdate
					+ "' and '" + reservetodate + "'";
		}
		// 判断搜索条件--会议时间，搜索某个时间段内的会议时间
		if (meetingfromdate != null && !meetingfromdate.equals("")
				&& meetingtodate != null && !meetingtodate.equals("")) {
			meetingdatesql = "and starttime  >='" + meetingfromdate
					+ "' and endtime <= '" + meetingtodate + "'";
		}
		String sql = "select meetingid,meetingname,roomname,starttime,endtime,reservationtime,employeename from meeting m,meetingroom r ,employee e "
				+ "where m.roomid = r.roomid AND m.reservationistid = e.employeeid "
				+ meetingnamesql
				+ roomnamesql
				+ reservernamesql
				+ reservedatesql + meetingdatesql;
		PreparedStatement pst = conn.prepareStatement(sql);
		List<SearchMeeting> list = new ArrayList<SearchMeeting>();
		SearchMeeting sMeeting = null;
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			sMeeting = new SearchMeeting();
			sMeeting.setMeetingid(rs.getInt(1));
			sMeeting.setMeetingname(rs.getString(2));
			sMeeting.setRoomname(rs.getString(3));
			sMeeting.setStarttime(rs.getTimestamp(4));
			sMeeting.setEndtime(rs.getTimestamp(5));
			sMeeting.setReservationtime(rs.getTimestamp(6));
			sMeeting.setEmployeename(rs.getString(7));
			list.add(sMeeting);
		}
		return list;
	}

	// 通过会议ID返回会议详情
	public Meeting selectMeetingDetail(int meetingid) throws Exception {
		this.openConnection();
		String sql = "select * from meeting where meetingid=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, meetingid);
		ResultSet rs = pst.executeQuery();
		Meeting meeting = null;
		while (rs.next()) {
			meeting = new Meeting();
			meeting.setMeetingid(rs.getInt("meetingid"));
			meeting.setMeetingname(rs.getString("meetingname"));
			meeting.setNumberofparticipants(rs.getInt("numberofparticipants"));
			meeting.setStarttime(rs.getTimestamp("starttime"));
			meeting.setEndtime(rs.getTimestamp("endtime"));
			meeting.setDescription(rs.getString("description"));
			meeting.setStatus(rs.getString("status"));
		}
		return meeting;
	}

	// 通过会议ID返回参会人员列表
	public List<Employee> selectParticipants(int meetingid) throws Exception {
		this.openConnection();
		String sql = "select employeename,phone,email from meetingparticipants m,employee e where e.employeeid = m.employeeid and m.meetingid= ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, meetingid);
		ResultSet rs = pst.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setEmployeename(rs.getString("employeename"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			list.add(employee);
		}
		return list;
	}

	// 通过id查询我的预定列表
	public List<SearchMeeting> viewMeeting(int empid) throws Exception {
		this.openConnection();
		String sql = "SELECT meetingid, meetingname,roomname,starttime,endtime,reservationtime,m.status FROM meeting m,meetingroom r "
				+ "WHERE m.roomid = r.roomid  AND reservationistid = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, empid);
		ResultSet rs = pst.executeQuery();
		List<SearchMeeting> list = new ArrayList<SearchMeeting>();
		SearchMeeting sMeeting = null;
		while (rs.next()) {
			sMeeting = new SearchMeeting();
			sMeeting.setMeetingid(rs.getInt(1));
			sMeeting.setMeetingname(rs.getString(2));
			sMeeting.setRoomname(rs.getString(3));
			sMeeting.setStarttime(rs.getTimestamp(4));
			sMeeting.setEndtime(rs.getTimestamp(5));
			sMeeting.setReservationtime(rs.getTimestamp(6));
			sMeeting.setStatus(rs.getString(7));
			list.add(sMeeting);

		}

		System.out.println(list);
		return list;
	}

	//通过id查询我参会的列表
	public List<SearchMeeting> viewMyMeeting(int empid) throws Exception {
		this.openConnection();
		String sql = "SELECT m.meetingid,meetingname,roomname,starttime,endtime,reservationtime,employeename,m.status FROM meeting m,meetingroom r,meetingparticipants p,employee e"
				+ " WHERE m.roomid = r.roomid AND  m.meetingid = p.meetingid AND p.employeeid=? AND m.reservationistid = e.employeeid;";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, empid);
		ResultSet rs = pst.executeQuery();
		List<SearchMeeting> list = new ArrayList<SearchMeeting>();
		SearchMeeting msMeeting = null;
		while (rs.next()) {
			msMeeting = new SearchMeeting();
			msMeeting.setMeetingid(rs.getInt(1));
			msMeeting.setMeetingname(rs.getString(2));
			msMeeting.setRoomname(rs.getString(3));
			msMeeting.setStarttime(rs.getTimestamp(4));
			msMeeting.setEndtime(rs.getTimestamp(5));
			msMeeting.setReservationtime(rs.getTimestamp(6));
			msMeeting.setEmployeename(rs.getString(7));
			msMeeting.setStatus(rs.getString(8));
			list.add(msMeeting);
		}
		return list;
	}

	//取消会议，更新会议状态为取消
	public void CancleMeeting(int meetingid) throws Exception {
		this.openConnection();
		String sqlupdate = "update Meeting set status='1',canceledtime=NOW() where Meetingid=?";
		PreparedStatement pstupdate = conn.prepareStatement(sqlupdate);
		pstupdate.setInt(1, meetingid);
		pstupdate.executeUpdate();
	}

	// 返回我未来七天要参加的会议信息
	public List<SearchMeeting> viewMyFutureMeeting(int empid) throws Exception {
		this.openConnection();
		String sql = "SELECT m.meetingid,meetingname,roomname,starttime,endtime  FROM meeting m,meetingparticipants p ,meetingroom r "+
		"WHERE starttime BETWEEN SYSDATE() AND concat(date_format(DATE_ADD(SYSDATE(),INTERVAL 7 DAY),'%Y-%c-%d'),' 23:59:59') "+
      " AND m.status='0' AND m.meetingid = p.meetingid AND employeeid = ? AND m.roomid = r.roomid;";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, empid);
		ResultSet rs = pst.executeQuery();
		List<SearchMeeting> list = new ArrayList<SearchMeeting>();
		SearchMeeting FutureMeeting = null;
		while (rs.next()) {
			FutureMeeting = new SearchMeeting();
			FutureMeeting.setMeetingid(rs.getInt(1));
			FutureMeeting.setMeetingname(rs.getString(2));
			FutureMeeting.setRoomname(rs.getString(3));
			FutureMeeting.setStarttime(rs.getTimestamp(4));
			FutureMeeting.setEndtime(rs.getTimestamp(5));
			list.add(FutureMeeting);
		}
		return list;
	}
	
	// 返回我未来七天要参加但是取消了的会议信息
	public List<SearchMeeting> viewMyCancleMeeting(int empid) throws Exception {
		this.openConnection();
		String sql = "SELECT m.meetingid,meetingname,roomname,starttime,endtime FROM meeting m,meetingroom r,meetingparticipants p "+
					" WHERE m.roomid = r.roomid AND  m.meetingid = p.meetingid AND m.status = '1' AND p.employeeid=?;";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, empid);
		ResultSet rs = pst.executeQuery();
		List<SearchMeeting> list = new ArrayList<SearchMeeting>();
		SearchMeeting CancleMeeting = null;
		while (rs.next()) {
			CancleMeeting = new SearchMeeting();
			CancleMeeting.setMeetingid(rs.getInt(1));
			CancleMeeting.setMeetingname(rs.getString(2));
			CancleMeeting.setRoomname(rs.getString(3));
			CancleMeeting.setStarttime(rs.getTimestamp(4));
			CancleMeeting.setEndtime(rs.getTimestamp(5));
			list.add(CancleMeeting);
		}
		return list;
	}

}
