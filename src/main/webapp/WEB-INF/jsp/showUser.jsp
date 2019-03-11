<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户信息</title>
        <style type="text/css">
            table,td{
                border: 1px solid;
                border-collapse: collapse;
            }
        </style>
</head>
<body>
<h3>用户信息展示！！！</h3>
<table>
            <tr>
                <td>用户ID</td>
                <td>用户名</td>
                <td>用户密码</td>
            </tr>
            <%--遍历Users集合中的User对象 --%>
            <c:forEach var="user" items="${Users}">
                <tr>
                    <td>${user.uid}</td>
                    <td>${user.userName}</td>
                    <td>${user.passWord}</td>
                </tr>
            </c:forEach>
            <c:if test="${not empty user}">
            	<tr>
              	   	<td>${user.uid}</td>
                 	<td>${user.userName}</td>
                 	<td>${user.passWord}</td>
             	</tr>
            </c:if>
        </table>
</html>