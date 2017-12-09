<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common03.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		function checkNum() {
			var roomnumber = document.getElementById("roomnumber").value;
			var validateMessage = document.getElementById("validateMessage");
			$.ajax({
				type : "get",
				url : "AjaxCheckNumSvl",
				data : {"roomnumber" : roomnumber},//要传给服务器的参数
				success : function(data) {//会在返回完整，请求成功时调用，其中的参数是返回值
					var validateMessage = document.getElementById("validateMessage")
					var msg = "门牌号已经存在";
					var color = "red";
					if (data == "0") {
						msg = "门牌号可以使用";
						color = "green";
					}
					validateMessage.innerHTML = "<font color = "+color+">"+ msg + "</font>";
				}
			});
		}
	</script>
	<div class="page-content">
		<div class="content-nav">会议预定 > 添加会议室</div>
		<form method="post" action="AddMeetingRoomSvl">
			<fieldset>
				<legend>会议室信息</legend>
				<table class="formtable">
					<tr>
						<td>门牌号:</td>
						<td><input id="roomnumber" name="roomnum" type="text"
							placeholder="例如：201" maxlength="10" onblur="checkNum()" />
							<div id="validateMessage"></div></td>

					</tr>
					<tr>
						<td>会议室名称:</td>
						<td><input id="roomname" name="roomname" type="text"
							placeholder="例如：第一会议室" maxlength="20" /></td>
					</tr>
					<tr>
						<td>最多容纳人数：</td>
						<td><input id="roomcapacity" name="capacity" type="text"
							placeholder="填写一个正整数" /></td>
					</tr>
					<tr>
						<td>当前状态：</td>
						<td><input type="radio" id="status" name="status"
							checked="checked" value="0" /><label for="status">可用</label> <input
							type="radio" id="status" name="status" value="1" /><label
							for="status">不可用</label></td>
					</tr>
					<tr>
						<td>备注：</td>
						<td><textarea id="description" name="description"
								maxlength="200" rows="5" cols="60" placeholder="200字以内的文字描述"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="command">
							<input type="submit" value="添加" class="clickbutton" /> 
							<input type="reset"  value="重置" class="clickbutton" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>