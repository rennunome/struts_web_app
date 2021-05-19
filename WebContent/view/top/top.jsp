<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top</title>
</head>
<body>
<div align="center">
			<%-- <% byte admin_flag = (byte)request.getSession().getAttribute("admin_flag");%>
			<% if (admin_flag == 1) {%> --%>
			<form action="list"  method="post">
			<input type="submit" value="問題と答えを確認・登録する ＞ " name= "listed" style="width: 250px">
			</form>
			<form action="test"  method="post">
			<input type="submit" value="テストをする ＞" style="width: 250px">
			</form>
			<form action="history"  method="post">
			<input type="submit" value="過去の採点結果をみる ＞" style="width: 250px">
			</form>
			<form action="userlist"  method="post">
			<input type="submit" value="ユーザを追加・編集する＞" style="width: 250px">
			</form>
			<%-- <% } else { %> --%>
			<form action="test"  method="post">
			<input type="submit" value="テストをする ＞" style="width: 250px">
			</form>
			<form action="history"  method="post">
			<input type="submit" value="過去の採点結果をみる ＞" style="width: 250px">
			</form>
			<%-- <% } %> --%>
		</div>
</body>
</html>