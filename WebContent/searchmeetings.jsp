<%@ page language="java" pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<mate charset="utf-8"></mate>
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common03.css" />
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div class="page-content">
		<div class="content-nav">会议预定 > 搜索会议</div>
		<form action="SearchMeetingSvl" method="get">
			<fieldset>
				<legend>搜索会议</legend>
				<table class="formtable">
					<tr>
						<td>会议名称：</td>
						<td><input type="text" id="meetingname" name="meetingname" maxlength="20" /></td>
						<td>会议室名称：</td>
						<td><input type="text" id="roomname" name="roomname" maxlength="20" /></td>
						<td>预定者姓名：</td>
						<td><input type="text" id="reservername" name="reservername" maxlength="20" /></td>
					</tr>
					<tr>
						<td>预定日期：</td>
						<td colspan="5">从&nbsp;
						<input class="Wdate" type="text" id="reservefromdate" name="reservefromdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 到&nbsp;
						<input class="Wdate" type="text" id="reservetodate" name="reservetodate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						</td>
					</tr>
					<tr>
						<td>会议日期：</td>
						<td colspan="5">从&nbsp;
						<input class="Wdate" type="text" id="meetingfromdate" name="meetingfromdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 到&nbsp;
						<input class="Wdate" type="text" id="meetingtodate" name="meetingtodate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
						</td>
					</tr>
					<tr>
						<td colspan="6" class="command"><input type="submit"
							class="clickbutton" value="查询" /> <input type="reset"
							class="clickbutton" value="重置" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
		<div>
			<h3 style="text-align: center; color: black">查询结果</h3>
		</div>
		<table class="listtable">
			<tr class="listheader">
				<th>会议名称</th>
				<th>会议室名称</th>
				<th>会议开始时间</th>
				<th>会议结束时间</th>
				<th>会议预定时间</th>
				<th>预定者</th>
				<th>操作</th>
			</tr>

		<c:forEach var="search" items="${requestScope.list}">
			<tr>
				<td>${search.meetingname }</td>
				<td>${search.roomname }</td>
				<td>${search.starttime }</td>
				<td>${search.endtime }</td>
				<td>${search.reservationtime }</td>
				<td>${search.employeename }</td>
				<td><a class="clickbutton" href="MeetingDetailSvl?meetingid=${search.meetingid}&code=search">查看详情</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>