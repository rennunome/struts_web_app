<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="org.apache.struts2.ServletActionContext"%>
<%@ page import="java.util.*"%>
<%@ page import="entity.User"%>
<%@ page import="util.DBUtil"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<head>
<meta charset="UTF-8">
<title>Top</title>
</head>
<body>
<h3>トップ画面</h3>
<div align="center">
			<!-- セッションに詰めたadmin_flag情報 -->
			<s:if test="%{#session.admin_flag = 1}">
			<s:form action="list"  method="POST">
			<s:submit value="問題・答えを登録する ＞" />
			</s:form>
			<s:form action="test"  method="post">
			<s:submit type="submit" value="テストをする ＞" />
			</s:form>
			<s:form action="history"  method="post">
			<s:submit type="submit" value="過去の採点結果をみる ＞" />
			</s:form>
			<s:form action="userlist"  method="post">
			<s:submit type="submit" value="ユーザを追加・編集する＞" />
			</s:form>
			</s:if>

			<s:else>
			<!-- 画面分岐 -->
			<s:form action="test"  method="post">
			<s:submit type="submit" value="テストをする ＞" />
			</s:form>
			<s:form action="history"  method="post">
			<s:submit type="submit" value="過去の採点結果をみる ＞" />
			</s:form>
			<s:form action="userlist"  method="post">
			<s:submit type="submit" value="ユーザを追加・編集する＞" />
			</s:form>
			</s:else>
</div>
</body>
</html>