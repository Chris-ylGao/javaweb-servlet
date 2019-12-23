<%--
  Created by IntelliJ IDEA.
  User: gyl
  Date: 23/12/2019
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>example of uploading file</title>
</head>
<body>
<h1>example of uploading file</h1>
<form method="post" action="/UploadServlet" enctype="multipart/form-data">
    Select File:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
