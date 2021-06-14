<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Register Confirm</title>
</head>
<body>
<h3>ユーザー登録確認画面</h3>
<s:form action="userdbregister" method="post">
		<label>ユーザー名：</label>
		<s:textfield name="user_name" placeholder="半角英数字のみ" />
		<br>
		<label>PW：</label>
		<s:textfield name="password" placeholder="半角英数字のみ8文字以上" />
		<br>
		<label>PW確認：</label>
		<s:textfield name="passwordconfirm" placeholder="半角英数字のみ8文字以上" />
		<br>
		<label>管理者権限：</label>
		<s:if test="(admin.equals(true))">
		<p>あり</p>
		<s:hidden name = "ad" value = "1" />
		</s:if>
		<s:else>
		<p>なし</p>
		<s:hidden name = "ad" value = "0" />
		</s:else>
		<br>
		<div align="right">
			<s:submit value="登録" />
		</div>
		</s:form>
</body>
</html>