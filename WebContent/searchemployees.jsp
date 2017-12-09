<%@ page language="java" pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common03.css" />
<style type="text/css">
</style>
</head>
<body>
	<div class="page-content">
		<div class="content-nav">人员管理 >搜索员工</div>
		<form method="post" action="SearchAllEmpSvl">
			<fieldset>
				<legend>搜索员工</legend>
				<table class="formtable">
					<tr>
						<td>姓名：</td>
						<td><input type="text" id="employeename" name="employeename"
							value="" maxlength="20" /></td>
						<td>账号名：</td>
						<td><input type="text" id="username" name="username" value=""
							maxlength="20" /></td>
						<td>状态：</td>
						<td><input type="radio" id="status" name="status" value="1" />
							<label>已批准</label> <input type="radio" id="status" name="status"
							value="0" /> <label>待审批</label> <input type="radio" id="status"
							name="status" value="2" /> <label>已关闭</label> <input
							type="radio" id="status" name="status" value="3" checked>
							<label>所有</label></td>
					</tr>
					<tr>
						<td colspan="6" class="command"><input type="submit"
							class="clickbutton" value="查询" /> <input type="reset"
							class="clickbutton" value="重置" /></td>
					</tr>
				</table>
			</fieldset>
		</form>

		<div>
			<h3 style="text-align: center; color: black">查询结果</h3>
			<div class="pager-header">
				<div class="header-info">
					共<span class="info-number">${requestScope.page.totalNum}</span>条结果，
					分成<span class="info-number">${requestScope.page.totalPage}</span>页显示，
					当前第<span class="info-number">${requestScope.page.currentPage}</span>页
				</div>
				<div class="header-nav">
					<input type="button" class="clickbutton" value="首页"
						onclick="window.location.href='SearchAllEmpSvl?employeename=${param.employeename}&username=${param.username}&status=${param.status}&currentPage=1'" />
					<c:if test="${requestScope.page.currentPage>1}">
						<input type="button" class="clickbutton" value="上页"
							onclick="window.location.href='SearchAllEmpSvl?employeename=${param.employeename}&username=${param.username}&status=${param.status}&currentPage=${requestScope.page.currentPage-1}'" />
					</c:if>
					<c:if
						test="${requestScope.page.currentPage<requestScope.page.totalPage}">
						<input type="button" class="clickbutton" value="下页"
							onclick="window.location.href='SearchAllEmpSvl?employeename=${param.employeename}&username=${param.username}&status=${param.status}&currentPage=${requestScope.page.currentPage+1}'" />
					</c:if>
					<input type="button" class="clickbutton" value="末页"
						onclick="window.location.href='SearchAllEmpSvl?employeename=${param.employeename}&username=${param.username}&status=${param.status}&currentPage=${requestScope.page.totalPage}'" />
					跳到第<input type="text" id="pageNum" name="pageNum"
						class="nav-number">页 <input type="button"
						class="clickbutton" value="跳转"
						onclick="gotoPage('${param.employeename}','${param.username}','${param.status}')" />
				</div>
			</div>
		</div>
		<table class="listtable">
			<tr class="listheader">
				<th>姓名</th>
				<th>账号名</th>
				<th>联系电话</th>
				<th>电子邮件</th>
				<th>操作</th>
			</tr>
			<c:forEach var="emp" items="${requestScope.page.list }">
				<tr>
					<td>${emp.employeename }</td>
					<td>${emp.username }</td>
					<td>${emp.phone }</td>
					<td>${emp.email }</td>
					<c:if test="${emp.status eq 2 }">
						<td>账号已关闭</td>
					</c:if>
					<c:if test="${emp.status ne 2 }">
						<td><a class="clickbutton"
							href="ApproveaccountSvl?type=no&employeeid=${emp.employeeid}&code=search">关闭账号</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		function gotoPage(employeename, username, status) {
			var pageNum = document.getElementById("pageNum").value;
			var total = $
			{
				requestScope.page.totalPage
			}
			;
			if (pageNum != null && pageNum != "") {
				if (pageNum > 0 && pageNum <= total) {
					window.location.href = "SearchAllEmpSvl?employeename="
							+ employeename + "&username=" + username
							+ "&status=" + status + "&currentPage=" + pageNum;
				} else {
					alert("请输入1到" + total + "的数字");
				}
			} else {
				alert("请输入整数");
			}
		}
	</script>
</body>
</html>