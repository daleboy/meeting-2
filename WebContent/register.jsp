<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		function validate() {
			var flag = false;
			var username = document.getElementById("username").value;
			$.ajax({
				type:"get",
				url:"CheckNameSvl",
				data:{"username":username},//要传给服务器的参数
				
				async:false,  //是否是异步刷新，当前为否
				
				success:function(data){//会在返回完整，请求成功时调用，其中的参数是返回值
					var validateMessage = document.getElementById("validateMessage")
					var msg = "账户已经存在";
					var color = "red";
					if(data=="success"){
						msg="账户名可以使用";
						color = "green";
						flag = true;
					}
					validateMessage.innerHTML = "<font color = "+color+">"+msg+"</font>";
				}
			})
			return flag;
		}
		//输入密码的验证，两次密码必须一致
		function check() {
			var flag = false;
			var pwd = document.getElementById("password").value;
			var confirm = document.getElementById("confirm").value;
			var confirminfo = document.getElementById("confirminfo");
			if (pwd != null && pwd != "" && confirm != null && confirm != "") {
				if (pwd != confirm) {
					confirminfo.innerHTML = "<font color = red >两次密码输入不一致</font>";
				} else {
					confirminfo.innerHTML = "<font color = green>两次输入的密码相符</font>";
					flag = true;
				}
			} else {
				confirminfo.innerHTML = "<font color = red >密码或者重复密码不能为空</font>";
			}
			
			return flag;
		}
		
		//提交之前的验证
		function checkAll(){
			var flag = false;
			var employeename = document.getElementById("employeename").value;
			var username = document.getElementById("username").value;
			if (employeename != null && employeename != "" && username != null
					&& username != "") {
				if (validate() == true) {
					if (check() == true) {
						flag = true;
					} else {
						alert("两次密码必须输入一致");
					}
				}else{
					alert("用户名已经存在");
				}
			}else{
				alert("账户名或员工姓名不能为空");
			}
			
			return flag;
		}
	</script>
	<div class="page-header">
		<div class="header-banner">
			<img alt="CoolMeeting" src="images/header.png">
		</div>
	</div>
	<div class="page-content">
		<div class="content-nav">人员管理 > 员工注册</div>
		<form name="form" action="RegistServlet" method="post">
			<fieldset>
				<legend>员工信息</legend>
				<%
					String msg = (String) request.getAttribute("msg");
				%>
				<%
					if (msg != null) {
				%>
				<tr>
					<td>提示信息:</td>
					<td><font color="red"><%=msg%></font></td>
				</tr>
				<%
					}
				%>
				<table class="formtable" style="width: 50%">
					<tr>
						<td>姓名：</td>
						<td><input type="text" id="employeename" name="employeename"
							maxlength="20" /></td>
					</tr>
					<tr>
						<td>账户名：</td>
						<td><input type="text" id="username" name="username"
							maxlength="20" onblur="validate()" />
							<div id="validateMessage"></div></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" id="password" name="password"
							maxlength="20" placeholder="请输入6位以上的密码" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input type="password" id="confirm" name="confirm"
							maxlength="20" onblur="check()" />
							<div id="confirminfo"></div></td>

					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" id="phone" name="phone" maxlength="20" /></td>
					</tr>
					<tr>
						<td>电子邮件：</td>
						<td><input type="text" id="email" name="email" maxlength="20" /></td>
					</tr>
					<tr>
						<td>所在部门：</td>
						<td><select name="departmentid">
								<c:forEach var="dep" items="${requestScope.deplists}">
								<option value="${dep.departmentid}" selected>${dep.departmentname}</option>
								</c:forEach>
							</select></td>
					</tr>

					<tr>
						<td colspan="6" class="command"><input type="submit"
							value="注册" class="clickbutton" onclick="return checkAll()" /> <input
							type="reset" value="重置" class="clickbutton" /></td>
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