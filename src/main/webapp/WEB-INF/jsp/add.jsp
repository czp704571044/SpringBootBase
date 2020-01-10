<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form method="post" enctype="multipart/form-data" id="file_upload" action="">
    　　<p>图片预览：</p>
    　　<div id="test-image-preview"></div>
    　　<p>
    　　　　<input type="file" id="test-image-file" name="test" accept="image/gif, image/jpeg, image/png, image/jpg">
    　　</p>
    <p id="test-file-info"></p>
</form>
</body>
</html>