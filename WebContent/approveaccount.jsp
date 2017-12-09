<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common03.css">
</head>
<body>
	<div class="page-content">
		<div class="content-nav">人员管理 > 注册审批</div>
		<c:if test="${requestScope.emplists!=null }">
			<table class="listtable">
				<caption>所有待审批注册信息：</caption>
				<tr class="listheader">
					<th>姓名</th>
					<th>账户名</th>
					<th>联系电话</th>
					<th>电子邮件</th>
					<th>操作</th>
				</tr>
					<c:forEach var = "emp" items="${requestScope.emplists}">
					<tr>
						<td>${emp.employeename }</td>
						<td>${emp.username }</td>
						<td>${emp.phone }</td>
						<td>${emp.email }</td>
						<td><input type="button" class="clickbutton" value="通过"
							onclick="window.location.href='ApproveaccountSvl?employeeid=${emp.employeeid}&type=yes'" />
							<input type="button" class="clickbutton" value="不通过"
							onclick="window.location.href='ApproveaccountSvl?employeeid=${emp.employeeid}&type=no'" /></td>
					</tr>
					</c:forEach>
			</table>
			</c:if>
	</div>
	
</body>
</html>