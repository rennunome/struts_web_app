<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
<h3>テスト結果画面</h3>
<!-- username さん -->
<s:property value="#session.name" />さん<br />
<!-- questions_id.length 問中 score 問正解です。 -->
<s:property value="qs" />問中<s:property value="scr" />問正解です。<br />
<!-- total 点でした。 -->
<s:property value="total" />点でした。<br />
<!-- timestamp -->
<s:property value="current_time" />
</body>
</html>