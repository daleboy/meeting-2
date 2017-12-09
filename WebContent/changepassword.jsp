<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
   
</script>
	<div class="page-content">
		<div class="content-nav">修改密码</div>
		<form action="ChangePwdSvl">
			<fieldset>
				<legend>修改密码信息</legend>
				<table class="formtable" style="width: 50%">
					<tr>
						<td>提示信息</td>
						<td><font color ="red">${requestScope.msg }</font></td>
						<td><input id="employeeid" type="hidden" name="employeeid" value="${sessionScope.employeeid }" /></td>
					</tr>
					<tr>
						<td>原密码:</td>
						<td><input id="origin" type="password" name="oldpwd" /></td>
					</tr>
					<tr>
						<td>新密码:</td>
						<td><input id="new" type="password" name="newpwd" /></td>
					</tr>
					<tr>
						<td>确认新密码：</td>
						<td><input id="confirm" type="password"  name="confirmnewpwd" /></td>
					</tr>
					<tr>
						<td colspan="2" class="command">
						<input type="submit"  value="确认修改" class="clickbutton" /> 
							<input type="button"  value="返回" class="clickbutton" onclick="window.history.back();" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>