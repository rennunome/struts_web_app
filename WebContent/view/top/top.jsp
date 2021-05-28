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
			<%-- <p>${session.user_admin}</p>
			<s:property value="#session['user_admin']" />
			<% byte admin = (byte)ActionContext.getContext().getSession().get("user_admin");%>
			<% if(admin == 1) {%> --%>
			<s:form action="list"  method="POST">
			<s:submit value="問題・答えを登録する ＞" />
			</s:form>
			<s:form action="test"  method="post">
			<input type="submit" value="テストをする ＞" style="width: 250px">
			</s:form>
			<s:form action="history"  method="post">
			<input type="submit" value="過去の採点結果をみる ＞" style="width: 250px">
			</s:form>
			<s:form action="userlist"  method="post">
			<input type="submit" value="ユーザを追加・編集する＞" style="width: 250px">
			</s:form>

			<!-- 画面分岐 -->
			<%-- <% } else { %>
			<s:form action="test"  method="post">
			<input type="submit" value="テストをする ＞" style="width: 250px">
			</s:form>
			<s:form action="history"  method="post">
			<input type="submit" value="過去の採点結果をみる ＞" style="width: 250px">
			</s:form>
			<% } %> --%>
		</div>
</body>
</html>