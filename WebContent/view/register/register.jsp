<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="@{webapp/js/addForm.js}"></script>
</head>
<body>
<s:if test="%{error_message_question != null}">
<s:property value="error_message_question" />
</s:if>
<s:if test="%{error_message_answer != null}">
<s:property value="error_message_answer" />
</s:if>
<s:form method="POST" action="registerConfirm" id="qaForm">
問題：
<s:textfield name="question"/><br />
答え：
<div id="form_area">
<s:textfield name="answer" id="answer" class="answer" /><br />
<s:textfield name="answer" id="answer" class="answer" />
</div>
<!-- 追加ボタン -->
<input type="button" value="追加" onClick="addForm()" /><br />
<s:submit value="確認"/>
</s:form>
</body>
</html>