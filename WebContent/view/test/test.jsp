<jsp:include page="/view/top/header.jsp"></jsp:include>
<jsp:include page="/view/top/header2.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
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
<s:if test="%{qList != null}">
<s:iterator value="%{qList}" begin="0" end="%{qList.size() -1}" status="sta">
<%-- <%-- <logic:iterate id="qList" name="qList" property="qList" indexId="index"> --%> --%>
問題：
<%-- <html:text name="qList" property="id" indexed="true"/>
<html:text name="qList" property="question" indexed="true"/> --%>
<s:textfield name="question" value="%{qList[#sta.index].question}"/>
<s:hidden name="questions_id" value="%{qList[#sta.index].id}"/>
<!-- answer input -->
<s:textfield name="test_answer"></s:textfield><br />
</s:iterator>
<%-- </logic:iterate> --%>
</s:if>
<s:submit value="採点" />
</s:form>
</body>
</html>