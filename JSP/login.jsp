<html lang="ja">
	<%@ page language="java" contentType="text/html; charset=utf-8" %>
	<title>ログイン</title>
	<head>
		<link rel="stylesheet" type="text/css" href="/EmployeeManagementSite/CSS/style.css">
		<script type = "text/javascript" src = "/EmployeeManagementSite/JavaScript/commonmethod.js"></script>
		<script type = "text/javascript" src = "/EmployeeManagementSite/JavaScript/login.js"></script>
	</head>
	
	<body>
		<div class = "top">
			<p>ログイン</p>
		</div>
		
		<form action = "/EmployeeManagementSite/LoginServlet" method = "post">
			<div class = "topspace1"></div>
			<div class = "linkmsg">
				<a href ="/EmployeeManagementSite/img/System_Constitution.png" target="_blank">社員登録システム構成図</a>
			</div>
			
			<div class = "linkmsg">
				<a href ="/EmployeeManagementSite/img/System_DB.png" target="_blank">社員登録システム_DB設計</a>
			</div>
			
			<div class = "leftspace1">
				<p>社員登録システム</p>
				<table class = "commontable">
					<tr>
						<td>userid</td>
						<td><input type = "text" id = "input1" name = "userid" size = "30" maxlength = "20"></td>
					</tr>
					
					<tr>
						<td>password</td>
						<td><input type = "password" id = "input2" name = "password" size = "30" maxlength = "20"></td>
					</tr>
				</table>
			</div>
			<div class = "leftspace2">
				<input type = "submit" name = "login" class = "commonbutton" value = "ログイン"
						onclick = "return isCheck()">
				<input type = "button" name = "register" class = "commonbutton" value = "登録" 
					   onclick = "location.href='/EmployeeManagementSite/JSP/createdata.jsp'">
			</div>
		</form>
	</body>
</html>
