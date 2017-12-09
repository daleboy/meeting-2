<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<mate charset="utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common03.css" />
</head>
<body>
	<div class="page-content">
		<div class="content-nav">个人中心 > 最新通知</div>
		<table class="listtable">
			<caption>未来7天我要参加的会议:</caption>
			<tr class="listheader">
				<th style="width: 300px">会议名称</th>
				<th>会议室</th>
				<th>起始时间</th>
				<th>结束时间</th>
				<th style="width: 100px">操作</th>
			</tr>
			<c:forEach var="futuremeeting" items="${requestScope.futurelist}">
				<tr>
					<td>${futuremeeting.meetingname }</td>
					<td>${futuremeeting.roomname }</td>
					<td><fmt:formatDate value="${futuremeeting.starttime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${futuremeeting.endtime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><a class="clickbutton"
						href="MeetingDetailSvl?meetingid=${futuremeeting.meetingid}&code=mymeet">查看会议</a></td>

				</tr>
			</c:forEach>
		</table>
		<table class="listtable">
			<caption>已取消的会议:</caption>
			<tr class="listheader">
				<th style="width: 300px">会议名称</th>
				<th>会议室</th>
				<th>起始时间</th>
				<th>结束时间</th>
				<th style="width: 100px">操作</th>
			</tr>
			<c:forEach var="canclemeeting" items="${requestScope.canclelist}">
				<tr>
					<td>${canclemeeting.meetingname }</td>
					<td>${canclemeeting.roomname }</td>
					<td><fmt:formatDate value="${canclemeeting.starttime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${canclemeeting.endtime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><a class="clickbutton"
						href="MeetingDetailSvl?meetingid=${canclemeeting.meetingid}&code=mymeet">查看会议</a></td>

				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>