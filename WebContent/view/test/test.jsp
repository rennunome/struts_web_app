<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
<h3>テスト画面</h3>
<s:form action="mark" method="POST">
<!-- get question -->
<s:iterator value="%{list}" begin= "0" end="%{list.size() -1}" status="sta">
問題：<s:textfield name="question" value="%{list[#sta.index]}"/>
<!-- answer input -->
<s:textfield name="test_answer"></s:textfield><br />
</s:iterator>
<s:submit value="採点" />
</s:form>
</body>
</html>