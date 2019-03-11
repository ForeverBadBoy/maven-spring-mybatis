<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<input id="basePath" type="hidden" value="<%=basePath%>"/>
<script type="text/javascript">
   	var basePath = document.getElementById("basePath").value;
</script> 
<!DOCTYPE html>
<html> 
	<head> 
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
		<title>Web Socket Demo</title> 
		<script type="text/javascript"> 
		var ws = null; 

		function startServer() {
			// 设定WebSocket,注意协议是ws，请求是指向对应的WebSocketServlet的
			var url = "ws://127.0.0.1:8080/maven-spring-mybatis/echo.ws";
			// 创建WebSocket实例，下面那个MozWebSocket是Firefox的实现
			if ('WebSocket' in window) { 
				ws = new WebSocket(url);
			} else if ('MozWebSocket' in window) { 
				ws = new MozWebSocket(url); 
			} else { 
				alert('Unsupported.'); 
				return; 
			}

			// WebSocket握手完成，连接成功的回调
			// 有个疑问，按理说new WebSocket的时候就会开始连接了，如果在设置onopen以前连接成功，是否还会触发这个回调
			ws.onopen = function() { 
				alert('Opened!'); 
	        };

	        // 收到服务器发送的文本消息, event.data表示文本内容
			ws.onmessage = function(event) { 
				alert('Receive message: ' + event.data); 
			};

			// 关闭WebSocket的回调
			ws.onclose = function() {
				alert('Closed!'); 
			};
		}

		function sendMyMessage() {
			var textMessage = document.getElementById('textMessage').value;
			
			if(ws != null && textMessage != '') {
				// 通过WebSocket想向服务器发送一个文本信息
				ws.send(textMessage);
			}
		}
		</script>
	</head>
	<body onload="startServer()"> 
		<input type="text" id="textMessage" size="20" />
		<input type="button" onclick="sendMyMessage()" value="Send">
	</body> 
</html>