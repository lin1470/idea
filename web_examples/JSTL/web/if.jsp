<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>使用 &lt;c:if&gt;标签</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--><style>
#one {
	margin:auto;
	background:url(images/logo.jpg);
	background-repeat:no-repeat;
	height:392px;
	width:722px;	
}
#two {
	position:relative;
	font-size: 12px;
	margin-top:150px;
	margin-left:190px;	
	width:500px;	
	float:left;
	font-size: 16px;
}
#three {
 position:relative;
 width:200px; 
 margin-top:150px;
 margin-right:60px;
 float:right;
}
</style>

  </head>
  
  <body>
  <div id="one">
		<div id="two">
		<c:if test="${empty param.username }" var="result">
	<form action="" method="post" name="form1">
	用户名：
	<input name="username" type="text" id="username">
	<input  type="submit" value="登录">
	</form>
</c:if>
			${!result}
<c:if test="${!result }">
	 欢迎[${param.username}]光临窗内网！
</c:if>
		</div>
	<div id="three">

		</div> 
	</div>
  	
  	
  </body>
</html>
