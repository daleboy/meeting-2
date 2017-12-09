<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common03.css">
</head>
<body>
	<div class="page-content">
		<div class="content-nav">会议预定 > 查看会议室</div>
		<table class="listtable">
			<caption>所有会议室：</caption>
			<tr class="listheader">
				<th>门牌编号</th>
				<th>会议室名称</th>
				<th>容纳人数</th>
				<th>当前状态</th>
				<th>操作</th>
			</tr>
			<c:forEach var="mr" items="${requestScope.mrlists}">
				<tr>
					<td>${mr.roomnum}</td>
					<td>${mr.roomname}</td>
					<td>${mr.capacity}</td>
					<c:if test="${mr.status eq 0}">
						<td>可用</td>
					</c:if>
					<c:if test="${mr.status eq 1}">
						<td>不可用</td>
					</c:if>
					<td><a class="clickbutton" href="MeetingRoomDetailSvl?code=allmr&roomid=${mr.roomid}">查看详情</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>