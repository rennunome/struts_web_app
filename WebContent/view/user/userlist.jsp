<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
<h3>ユーザーリスト</h3>
	<!-- admin = 1だったら新規登録ボタン表示 -->
	<s:if test="%{#session.user_admin == 1}">
			<s:form action="userregister" method="post">
				<s:submit value="新規登録" />
			</s:form>
	</s:if>
	<br />
	<!-- user list -->
	<table border="1">
	<tr>
	<th>ID</th>
	<th>権限</th>
	<th>ユーザー名</th>
	</tr>
	<s:iterator value="users">
	<!-- id -->
	<tr>
	<td><s:property value="id" /></td>
	<!-- admin -->
	<td>
		<s:if test="%{admin_flag == 1}">
			管理者
		</s:if>
		<s:else>
			一般
		</s:else>
	</td>
	<!-- name -->
	<td><s:property value="name" /></td>
	<!-- admin = 1だったら編集と削除ボタン -->
	<s:if test="%{#session.user_admin == 1}">
	<td>
			<s:form action="useredit" method="post">
				<s:hidden name="user_id" value="%{id}" />
				<s:submit value="編集" />
			</s:form>
	</td>
	<td>
			<s:form action="userdeleteconfirm" method="post">
				<s:hidden name="user_id" value="%{id}" />
				<s:submit value="削除" />
			</s:form>
	</td>
	</s:if>
	</tr>
	</s:iterator>
	</table>
</body>
</html>