<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common03.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div class="page-content">
		<div class="content-nav">人员管理 > 部门管理</div>

		<form action="AddDepartmentSvl" method="post">
			<fieldset>
				<legend>添加部门</legend>
				部门名称： <input type="text" name="departmentname" maxlength="20" /> <input
					type="hidden" name="code" value="add"> <input type="submit"
					class="clickbutton" value="添加" />
			</fieldset>
		</form>
		<c:if test="${requestScope.deplists!=null }">
			<table class="listtable">
				<caption>所有部门：</caption>
				<tr class="listheader">
					<th>部门编号</th>
					<th>部门名称</th>
					<th>操作</th>
				</tr>
				<c:forEach var="dep" items="${requestScope.deplists}">
					<tr>
						<td>${dep.departmentid}</td>
						<td><input type="text" id="${dep.departmentid}" style="background-color: transparent;"value="${dep.departmentname}" /></td>
						<td><a class="clickbutton" href="DeleteDepSvl?departmentid=${dep.departmentid}">删除</a>
							<input class="clickbutton" type="button" value="修改并保存" onclick="updateDep(${dep.departmentid})" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>


	<script type="text/javascript">
		/*onclick :点击事件，触发事件的时候，调用updateDep()函数，并且把部门ID传过来*/
		function updateDep(departmentid){
			var departmentname = document.getElementById(departmentid).value;//获取Input标签里面的内容
			//ajax请求，局部刷新
			 $.ajax({
				type:"get",
				url:"UpdateDepSvl",
				data:{"departmentid":departmentid,"departmentname":departmentname},
			}); 
		}
	</script>
</body>
</html>