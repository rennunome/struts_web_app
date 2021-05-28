<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><!-- ページの設定 -->
<%@ taglib prefix="s" uri="/struts-tags" %><!-- struts2のカスタムタグ(s:formとか)を使えるようにしている -->

<html>
<head>
  <meta charset = "UTF-8">
  <title>Login</title>
</head>
<body>
<h3>ログイン画面</h3>
<s:form method="POST" action="login"><!-- s:formタグで囲まれた情報が、struts.xmlのactionタグ内のname属性LoginActionで指定したactionクラスに渡される -->
ID: <s:textfield name="id"/><br /><!-- "name"と同名のactionクラスのフィールドに情報を渡す ※ブラウザでは<imput type="text" name="id">と認識される-->
PASSWORD: <s:password name="password" /><!-- "password"と同名のactionクラスのフィールドに情報を渡す ※ブラウザでは<imput type="password" name="password">と認識される-->
<s:submit value="ログイン"/><!-- ブラウザでは<imput type="submit" value="ログイン">と認識される -->
</s:form>
</body>
</html>