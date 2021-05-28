<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/WebContent/webapp/js/addForm.js}"></script>
</head>
<body>
<h3>編集画面</h3>
	<s:form action="editConfirm" method="POST">
問題：<s:textfield name="questions_id" value="%{questions_id}" />
		<s:textfield name="question" value="%{question}" />
		<br />
答え：<s:textfield name="answers_id" value="%{answers_id}" />
		<s:textfield name="answer" value="%{answer}" />
		<br />
		<!--答えが単数しか登録されないためiteratorの記述はコメントアウト -->
		<%-- <s:iterator value="a" begin= "0" end="%{a.length -1}" status="asta"> --%>
		<%-- </s:iterator> --%>
		<!-- 追加ボタン -->
		<!-- 以下全て機能せず -->
		<input type="button" value="追加" onclick="addForm()" />
		<html:button property="btn" value="ついか" onclick="addForm()" />
		<br />
		<button value="ツイカ" onclick="addForm()"></button>
		<s:submit value="確認" />
	</s:form>
</body>
</html>