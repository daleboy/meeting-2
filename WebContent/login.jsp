<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
</head>
<body>

	<div class="page-header">
		<div class="header-banner">
			<img alt="CoolMeeting" src="images/header.png">
		</div>
	</div>
	<div class="page-content">
		<div class="content-nav">登录</div>
		<form action="LoginSvl" method="post">
			<fieldset>
				<legend>登录信息</legend>
				<tr>
					<td>提示信息：</td>
					<td><font color="red">${requestScope.msg}</font></td>
				</tr>
				<table class="formtable" style="width: 50%">
					<tr>
						<td>账号名:</td>
						<td><input id="accountname" name="username" type="text" /></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input id="new" name="password" type="password" /></td>
					</tr>
					<tr>
					<!-- <td>
					  <select id="timelength" name="timelength">
					    <option value="0">每次需要登入</option>
					    <option value="10">10天内</option>
					    <option value="30">30天内</option>
					  </select>
					</td> -->
					</tr>
					<tr>
						<td colspan="2" class="command">
						<input type="submit"  value="登录" class="clickbutton" /> 
						<input type="button"  value="返回" class="clickbutton"  onclick="window.history.back();" />
						<input type="button"  value="注册" class="clickbutton" onclick="window.location.href='ViewDepartmentSvl?code=register'"/></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>

	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>

</body>
</html>