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
<title>Register</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/WebContent/webapp/js/addForm.js}"></script>
</head>
<body>
<h3>新規登録画面</h3>
<s:form method="POST" action="registerConfirm" id="qaForm">
<s:if test="%{error_message_question != null}">
<s:property value="error_message_question" /><br />
</s:if>
<s:if test="%{error_message_answer != null}"><br />
<s:property value="error_message_answer" />
</s:if>
問題：<br />
<s:textfield name="question"/><br />
答え：
<div id="form_area">
<s:textfield name="answer" id="answer" class="answer" /><br />
</div>
<!-- 追加ボタン -->
<!-- 以下全て機能せず -->
<input type="button" value="追加" onclick="addForm()" />
<html:button property="btn" value="ついか" onclick="addForm()" /><br />
<button value="ツイカ" onclick="addForm()" ></button>
<s:submit value="確認"/>
</s:form>
</body>
</html>