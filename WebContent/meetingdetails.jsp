<%@ page language="java" pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<mate charset="utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common03.css" />
<style type="text/css">
#divfrom {
	float: left;
	width: 200px;
}

#divto {
	float: left;
	width: 200px;
}

#divoperator {
	float: left;
	width: 50px;
	padding: 60px 5px;
}

#divoperator input[type="button"] {
	margin: 10px 0;
}

#selDepartments {
	display: block;
	width: 100%;
}

#selEmployees {
	display: block;
	width: 100%;
	height: 200px;
}

#selSelectedEmployees {
	display: block;
	width: 100%;
	height: 225px;
}
</style>
</head>
<body>

	<div class="page-content">
		<div class="content-nav">会议预定 > 会议详情</div>
		<form>
			<fieldset>
				<legend>会议信息</legend>
				<table class="formtable">
					<tr>
						<td>会议状态：</td>
						<c:if test="${requestScope.meeting.status eq 0}">
							<td><font color="blue">会议按时举办</font></td>
						</c:if>
						<c:if test="${requestScope.meeting.status eq 1}">
							<td><font style="font-weight:bold" color="red">会议已经取消</font></td>
						</c:if>
					</tr>
					<tr>
						<td>会议名称：</td>
						<td>${requestScope.meeting.meetingname }</td>
					</tr>
					<tr>
						<td>预计参加人数：</td>
						<td>${requestScope.meeting.numberofparticipants }</td>
					</tr>
					<tr>
						<td>预计开始时间：</td>
						<td>${requestScope.meeting.starttime }</td>
					</tr>
					<tr>
						<td>预计结束时间：</td>
						<td>${requestScope.meeting.endtime }</td>
					</tr>
					<tr>
						<td>会议说明：</td>
						<td><textarea id="description" rows="5" readonly>${requestScope.meeting.description }</textarea>
						</td>
					</tr>
					<tr>
						<td>参会人员：</td>
						<td>
							<table class="listtable">
								<tr class="listheader">
									<th>姓名</th>
									<th>联系电话</th>
									<td>电子邮件</td>
								</tr>
								<c:forEach var="emp" items="${requestScope.list}">
									<tr>
										<td>${emp.employeename}</td>
										<td>${emp.phone }</td>
										<td>${emp.email }</td>
									</tr>
								</c:forEach>

							</table>
						</td>
					</tr>
					<tr>
						<td class="command" colspan="1"><input type="button"
							class="clickbutton" value="返回" onclick="window.history.back();" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>