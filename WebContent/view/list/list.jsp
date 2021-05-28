<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import="entity.Question"%>
<%@ page import="entity.Answer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
<h3>問題・答え一覧画面</h3>
<div align="center">
		<s:form action="register" method="post">
		<s:submit value="新規登録" />
		</s:form>
</div>
<br>
<s:iterator value="%{questions}" begin= "0" end="%{questions.size() -1}" status="qsta">
	問題：
	<s:property value="questions[#qsta.index].id"/>
	<s:property value="questions[#qsta.index].question" />
	<br />
	<s:iterator value="%{answers}" begin= "0" end="%{answers.size() -1}" status="asta">
		<s:if test="%{questions[#qsta.index].id == answers[#asta.index].questions_id}">
		答え：<s:property value="answers[#asta.index].id"/>
			<s:property value="answers[#asta.index].answer" />
			<br />
		</s:if>
		</s:iterator>
		<s:form action="edit" method="post">
			<s:hidden name="questions_id" value="%{answers[#asta.index].questions_id}" />
			<s:hidden name="answers_id" value="%{answers[#asta.index].id}" />
			<s:submit value="編集" />
		</s:form>
		<s:form action="deleteConfirm" method="post">
			<s:hidden name="questions_id" value="%{answers[#asta.index].questions_id}" />
			<s:hidden name="answers_id" value="%{answers[#asta.index].id}" />
			<s:submit value="削除" />
		</s:form>
	</s:iterator>
</body>
</html>