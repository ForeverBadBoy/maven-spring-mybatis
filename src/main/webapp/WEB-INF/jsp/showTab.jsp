<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示表格信息</title>
        <style type="text/css">
            table,td{
                border: 1px solid;
                border-collapse: collapse;
                min-width: 40px;
            }
        </style>
</head>
<body>
<h3>表格信息展示！！！</h3>
${tabInfo }<br/><br/>
<table>		
			<tr>
            <c:forEach var="map" items="${tabInfo[0]}">
            	<td>${map.key}</td>
            </c:forEach>
           	</tr>	 
            <%--遍历集合中的对象 --%>
            <c:forEach var="list" items="${tabInfo}">
                <tr>
                    <c:forEach var="map" items="${list}">
            			<td title="${map}">${map.value}</td>
            		</c:forEach>
                </tr>
            </c:forEach>
        </table>
</html>