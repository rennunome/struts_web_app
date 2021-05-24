<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div align="center">
		<s:form action="register" method="post">
		<s:submit value="新規登録" />
		</s:form>
</div>
<br>
	<%-- <%
	for (int i = 0; i < questions_count.length; i++) {
	%> --%>
	<%-- <c:forEach var="i" begin="1" end="${questions_count}" step="1"> --%>
	問題：
	<s:property value="qid" />
	<s:property value="question" />
	<br />
	<%-- <c:forEach var="j" begin="1" end="${answers_count}" step="1"> --%>
	<s:iterator value="%{answers_count}" var="aid" status="sta">
		<%-- <c:if test="${qid == questions_id}"> --%>
			答え：<s:property value="aid" />
			<s:property value="answer" />
			<br />
		<%-- </c:if> --%>
		<s:form action="edit" method="post">
			<html:hidden property="answer_id" value="${aid}" />
			<s:submit value="編集" />
		</s:form>
		<s:form action="deleteConfirm" method="post">
			<html:hidden property="answer_id" value="${aid}" />
			<s:submit value="削除" />
		</s:form>
	</s:iterator>
	<%-- <% } %> --%>
</body>
</html>