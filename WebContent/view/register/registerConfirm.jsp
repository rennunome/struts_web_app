<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Confirm</title>
</head>
<body>
<h3>新規登録確認画面</h3>
<s:form method="POST" action="registerDb">
問題：
<%-- <s:property value="question" /><br /> --%>
<s:textfield name="question" value="%{question}" /><br />
答え：
<s:iterator value="answer" begin= "0" end="%{answer.length -1}" status="asta">
<%-- <s:property value="answer[#asta.index]" /><br /> --%>
<s:textfield name="answer" value="%{answer[#asta.index]}" /><br />
</s:iterator>
<s:submit value="登録"/>
</s:form>
</body>
</html>