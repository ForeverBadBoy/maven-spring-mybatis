<%@ page language="java" import="java.util.*,cn.com.kid.webSocket.WebSocketTest"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<input id="basePath" type="hidden" value="<%=basePath%>"/>
<script type="text/javascript">
   	var basePath = document.getElementById("basePath").value;
</script> 
<head>
<title>index</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%  
    String user = (String)session.getAttribute("user"); 
	System.out.println("session:"+user);
	System.out.println("request1:"+request.getSession().getAttribute("user"));
    if(user == null){  
        //为用户生成昵称  
        user = "游客" + WebSocketTest.ONLINE_USER_COUNT;  
        WebSocketTest.ONLINE_USER_COUNT ++;  
        session.setAttribute("user", user);  
        System.out.println("request:"+request.getSession().getAttribute("user"));
    }  
    pageContext.setAttribute("user", user);  
%>  
<script type="text/javascript">  
    var user = "${user}";  
</script> 
<script type="text/javascript" src="resource/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$.post('showTab',{'tableName':'USER_TABLES'},function(data){
		data = data['data'];
		for(var i=0;i<data.length;i++){
			$('#tab').append('<option>'+data[i]['TABLE_NAME']+'</option>');
		}
	});
	$('#search').click(function(){
		window.location.href = "${pageContext.request.contextPath}/showTabToPage?tableName="+$('#tab').val();
	});
	var websocket = new WebSocket(encodeURI('ws://localhost:8080/maven-spring-mybatis/message'));
	websocket.onopen = function(e) { 
		console.log(e);
		console.log(e.data);
    };
    // 收到服务器发送的文本消息, event.data表示文本内容
	websocket.onmessage = function(event) {
    	console.log(event);
    	var message = JSON.parse(event.data);
		console.log(message);
	};
	websocket.send('aaa');
});
</script>
</head>
<body>
	<h2>Hello World!  ${user}</h2>
	<form action="ServletDemo" method="post">
		用户名:<input type="text" name="name" value="${requestScope.name}">
		密码:<input type="password" name="password" value="${requestScope.password}">
		<input type="submit" value="提交"> 
	</form>
	<c:out value="${requestScope.name}"></c:out>
	
	<p><a href="${pageContext.request.contextPath}/user/showUser?id=23" style="text-decoration:none;">/user/showUser</a></p>
	<p><a href="${pageContext.request.contextPath}/user/showAllUser" style="text-decoration:none;">/user/showAllUser</a></p>
	<p><a href="${pageContext.request.contextPath}/showTab?tableName=students" style="text-decoration:none;">/showTab</a></p>
	<select id="tab">
		
	</select>
	<input id="search" type="button" value="查询"/>
</body>
</html>
