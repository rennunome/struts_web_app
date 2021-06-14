<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Delete</title>
</head>
<body>
<h3>ユーザー削除確認画面</h3>
<s:form action="userdelete" method="POST">
		<div>
			<label>ID：</label>
			<s:textfield name="user_id" value="%{user_id}" readonly= "readonly" /><br>
		</div>
		<div>
			<label>ユーザー名：</label>
			<s:textfield name="user_name" value="%{user_name}" readonly= "readonly" /><br>
		</div>
		<div>
			<label>PW：</label>
			<s:textfield name="password" value="%{password}" readonly= "readonly" /><br>
		</div>
		<div>
			<label>管理者権限：</label>
			<s:if test="%{admin_flag == 1}">
			<s:textfield name="admin_flag" value="あり" readonly= "readonly" />
			<s:hidden name="admin" value="1" />
			</s:if>
			<s:else>
			<s:textfield name="admin_flag" value="なし" readonly= "readonly" />
			<s:hidden name="admin" value="0" />
			</s:else>
			<br>
		</div>
		<div align="right">
			<s:submit value="削除" />
		</div>
		</s:form>
</body>
</html>