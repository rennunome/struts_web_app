<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Confirm</title>
</head>
<body>
<h3>編集確認画面</h3>
<s:form action="editDb" method="POST">
問題：<s:textfield name="questions_id" value="%{questions_id}" />
		<s:textfield name="question" value="%{question}" /><br />
答え：<s:textfield name="answers_id" value="%{answers_id}" />
		<s:textfield name="answer" value="%{answer}" /><br />
		<!--答えが単数しか登録されないためiteratorの記述はコメントアウト -->
		<%-- <s:iterator value="a" begin= "0" end="%{a.length -1}" status="asta"> --%>
		<%-- </s:iterator> --%>
		<s:submit value="更新" />
</s:form>
</body>
</html>