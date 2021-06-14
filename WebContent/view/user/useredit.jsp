<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Edit</title>
</head>
<body>
<h3>ユーザー編集画面</h3>
<s:form action="usereditconfirm" method="POST">
		<div>
			<label>ID：</label>
			<s:textfield name="user_id" value="%{user_id}" /><br>
		</div>
		<div>
			<label>ユーザー名：</label>
			<s:textfield name="user_name" value="%{user_name}" /><br>
		</div>
		<div>
		<!-- password error message -->
		<s:if test="%{error_message_pw != null}">
		<s:property value="error_message_pw" /><br />
		</s:if>
			<label>PW：</label>
			<s:textfield name="password" value="%{password}" /><br>
		</div>
		<div>
			<label>PW確認：</label>
			<s:textfield name="passwordconfirm" /><br>
		</div>
		<div>
			<label>管理者権限：</label>
			<s:if test="%{admin_flag == 1}">
			<s:checkbox name="admin_flag" value="true" />
			</s:if>
			<s:else>
			<s:checkbox name="admin_flag" value="false" />
			</s:else>
			<br>
		</div>
		<div align="right">
			<s:submit value="確認" />
		</div>
		</s:form>
</body>
</html>