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
	<p>${qid}</p><br />
	<p>${question}</p><br />
		 <c:if test="${qid == aid}">
			<p>${aid}</p><br />
			<p>${answer}</p>
		</c:if>
	<s:form action="edit" method="post">
	 <html:text property="answer_id" value="${aid}" />
	 <s:submit value="編集"/>
	</s:form>
	<s:form action="deleteConfirm" method="post">
	 <html:text property="answer_id" value="${aid}" />
	 <s:submit value="削除"/>
	</s:form>
</body>
</html>