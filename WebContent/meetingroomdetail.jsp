<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common03.css"/>
    </head>
    <body>
       
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 修改会议室信息
                </div>
                <form action="UpdateMeetingRoomSvl" method="post">
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                        
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <input type="hidden" name="roomid" value="${mroom.roomid}">
                                    <input id="roomnumber" name="roomnum" type="text"  maxlength="10" value="${mroom.roomnum}" />
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input id="roomname" name="roomname" type="text" maxlength="20" value="${mroom.roomname}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input id="roomcapacity" name="capacity" type="text" value="${mroom.capacity}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                                <td>
                                <c:if test="${mroom.status eq 0}">
                                    <input type="radio" id="status" name="status" checked="checked" value="0"/><label for="status">可用</label>
                                    <input type="radio" id="status" name="status" value="1"/><label for="status" >不可用</label>
                     			</c:if>
                     			<c:if test="${mroom.status eq 1}">
                                    <input type="radio" id="status" name="status"  value="0"/><label for="status">可用</label>
                                    <input type="radio" id="status" name="status" checked="checked" value="1"><label for="status" >不可用</label>
                                </c:if>
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea id="description"  name="description" maxlength="200" rows="5" cols="60" >${mroom.description}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" class="clickbutton"/>
                                    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
      
    </body>
</html>