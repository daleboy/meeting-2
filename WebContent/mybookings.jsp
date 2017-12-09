<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<mate charset="utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common03.css" />
<style type="text/css">
</style>
</head>
<body>

	<div class="page-content">
		<div class="content-nav">个人中心 > 我的预定</div>
		<table class="listtable">
			<caption>我预定的会议：</caption>
			<tr class="listheader">
				<th>会议名称</th>
				<th>会议室名称</th>
				<th>会议开始时间</th>
				<th>会议结束时间</th>
				<th>会议预定时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="meeting" items="${requestScope.list }">
				<tr>
					<td>${meeting.meetingname }</td>
					<td>${meeting.roomname }</td>
					<td><fmt:formatDate value="${meeting.starttime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${meeting.endtime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${meeting.reservationtime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<c:if test="${meeting.status eq 0}">
					<td><a class="clickbutton"
						href="MeetingDetailSvl?meetingid=${meeting.meetingid}&code=book">查看 / 取消</a></td>
					</c:if>
					<c:if test="${meeting.status eq 1}">
					<td><a class="clickbutton"
						href="#">会议已取消</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>