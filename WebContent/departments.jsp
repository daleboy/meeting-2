﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <mate charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
        <div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                欢迎您，<strong>admin</strong>
                <a href="changepassword.html">[修改密码]</a>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="notifications.html">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybookings.html">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="mymeetings.html">我的会议</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="departments.html">部门管理</></li>
                        <li class="sidebar-menuitem"><a href="register.html">员工注册</a></li>
                        <li class="sidebar-menuitem"><a href="approveaccount.html">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="searchemployees.html">搜索员工</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="addmeetingroom.html">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a href="meetingrooms.html">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="bookmeeting.html">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.html">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 部门管理
                </div>
                <form>
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" id="departmentname" maxlength="20"/>
                        <input type="submit" class="clickbutton" value="添加"/>
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>技术部</td>
                        <td>
                            <a class="clickbutton" href="#">编辑</a>
                            <a class="clickbutton" href="#">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>
                            <input type="text" value="销售部"/>
                        </td>
                        <td>
                            <a class="clickbutton" href="#">编辑</a>
                            <a class="clickbutton" href="#">取消</a>
                            <a class="clickbutton" href="#">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>市场部</td>
                        <td>
                            <a class="clickbutton" href="#">编辑</a>
                            <a class="clickbutton" href="#">删除</a>
                        </td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>行政部</td>
                        <td>
                            <a class="clickbutton" href="#">编辑</a>
                            <a class="clickbutton" href="#">删除</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>