<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="entity.Question"%>
<%@ page import="entity.Answer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Confirm</title>
</head>
<body>
	<s:form action="delete" method="POST">
	<!-- 出力される↓ -->
問題：<s:textfield name="questions_id" value="%{questions_id}" />
	<!-- 白紙のテキストフィールドが出力される↓ -->
		<s:textfield name="question" value="%{question}" />
		<!-- 出力されない↓ -->
		<s:property value="%{question}" />
		<br />
		<!-- 出力される↓ -->
答え：<s:textfield name="answers_id" value="%{answers_id}" />
		<!-- 白紙のテキストフィールドが出力される↓ -->
		<s:textfield name="answer" value="%{answer}" />
		<!-- 出力されない↓ -->
		<s:property value="%{answer}" />
		<!--答えが単数しか登録されないためiteratorの記述はコメントアウト -->
		<%-- <s:iterator value="a" begin= "0" end="%{a.length -1}" status="asta"> --%>
		<%-- </s:iterator> --%>
		<s:submit value="削除" />
	</s:form>
</body>
</html>