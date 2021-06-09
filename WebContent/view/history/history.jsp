<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History</title>
</head>
<body>
<div align="center">
				<h3>履歴</h3>
				<table border="1">
					<tr>
						<th>氏名</th>
						<th>得点</th>
						<th>採点時間</th>
					</tr>
					<s:iterator value="hlist">
					<tr>
						<td><s:property value="#session.user_name" />さん</td>
						<td><s:property value="point" />点</td>
						<td><s:property value="created_at" /></td>
					</tr>
					</s:iterator>
				</table>
			</div>
</body>
</html>