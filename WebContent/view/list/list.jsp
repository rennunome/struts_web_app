<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
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
		<s:submit type="input"  value="新規登録" />
		</s:form>
</div>
	<br>
	<%
	List<Question> q_list = (List<Question>) request.getAttribute("q_list");
	%>
	<c:forEach var="q_list" items="${q_list}">
	<p>${q_list.id}</p><br />
	<p>${q_list.question}</p><br />
	<c:forEach var="ca_list" items="${ca_list}">
		 <c:if test="${q_list.id == ca_list.questions_id}">
			<p>${ca_list.id}</p><br />
			<p>${ca_list.answer}</p>
		</c:if>
	<s:form action="edit" method="post">
	 <html:hidden property="answer_id" value="${ca_list.id}" />
	 <s:submit value="編集"/>
	</s:form>
	<s:form action="deleteConfirm" method="post">
	 <html:hidden property="answer_id" value="${ca_list.id}" />
	 <s:submit value="削除"/>
	</s:form>
	</c:forEach>
	</c:forEach>
</body>
</html>