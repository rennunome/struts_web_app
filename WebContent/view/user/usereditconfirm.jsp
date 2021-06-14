<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Edit Confirm</title>
</head>
<body>
<h3>ユーザー編集確認画面</h3>
<s:form action="usereditdb" method="POST">
			<label>ID：</label>
			<s:textfield name="user_id" value="%{user_id}" /><br>
			<label>ユーザー名：</label>
			<s:textfield name="user_name" value="%{user_name}" /><br>
			<label>PW：</label>
			<s:textfield name="password" value="%{password}" /><br>
			<label>PW確認：</label>
			<s:textfield name="passwordconfirm" value="%{passwordconfirm}"/><br>
			<label>管理者権限：</label>
			<s:if test="%{admin_flag == 1}">
			<s:textfield name="admin_flag" value="管理者" />
			<s:hidden name="admin_flag" value="1" />
			</s:if>
			<s:else>
			<s:textfield name="admin_flag" value="一般" />
			<s:hidden name="admin_flag" value="0" />
			</s:else>
		<div align="right">
			<s:submit value="更新" />
		</div>
</s:form>
</body>
</html>