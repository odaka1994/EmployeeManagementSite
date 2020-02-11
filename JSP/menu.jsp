<html lang="ja">
	<%@ page contentType="text/html; charset=UTF-8" %>
	<title>メニュー</title>
	<head>
		<link rel="stylesheet" type="text/css" href="/EmployeeManagementSite/CSS/style.css">
		<script type = "text/javascript" src = "/EmployeeManagementSite/JavaScript/commonmethod.js"></script>
		<script type = "text/javascript" src = "/EmployeeManagementSite/JavaScript/menu.js"></script>
	</head>
	<body>
		<div class = "top">
			<p>メニュー</p>
		</div>
		<div class = "topspace1"></div>
		<div class = "leftspace2">
			<a href = "/EmployeeManagementSite/JSP/login.jsp">ログアウト</a>
		</div>
		<form action = "/EmployeeManagementSite/MenuServlet" method = "get">
			<div class = "leftspace1">
				<input type = "button" class = "menubutton" name = "mb1" onclick = "displaydata()" value = "ユーザー情報表示">
				<input type = "button" class = "menubutton" name = "mb2" onclick = "changedata()" value = "ユーザー情報変更">
				<input type = "submit" class = "menubutton" name = "mb3" onclick = "return isDelete()" value = "退社">
			</div>
		</form>
	</body>
</html>
