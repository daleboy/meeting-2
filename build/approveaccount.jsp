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
			<table class="listtable">
				<caption>所有待审批注册信息：</caption>
				<tr class="listheader">
					<th>姓名</th>
					<th>账户名</th>
					<th>联系电话</th>
					<th>电子邮件</th>
					<th>操作</th>
				</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="button" class="clickbutton" value="通过"
							onclick="#" />
							<input type="button" class="clickbutton" value="不通过"
							onclick="#" /></td>
					</tr>
			</table>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>