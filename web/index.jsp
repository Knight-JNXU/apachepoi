<%--
  Created by IntelliJ IDEA.
  User: Knight_JXNU
  Date: 2016/9/22
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ApachePOI</title>
</head>
<body>
<h4>导出</h4>
<form action="<%=request.getContextPath()%>/apachepoi/export" method="post">
  fileUrl:<input type="text" name="fileUrl1" value="C:\Users\MW\Desktop\newFile.xlsx" size="40">
  <input type="submit" value="导出">
</form>
<h4>导入</h4>
<form action="<%=request.getContextPath()%>/apachepoi/importFromExcel" method="post">
  fileUrl:<input type="text" name="fileUrl2" value="C:\Users\MW\Desktop\newFile.xlsx" size="40">
  <input type="submit" value="导入">
</form>
</body>
</html>
