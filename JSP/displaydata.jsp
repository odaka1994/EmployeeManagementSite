<html lang="ja">
	<%@ page contentType="text/html; charset=UTF-8" %>
	<title>ユーザー情報</title>
	<head>
		<link rel="stylesheet" type="text/css" href="/EmployeeManagementSite/CSS/style.css">
		<script type = "text/javascript" src = "/EmployeeManagementSite/JavaScript/displaydata.js" defer></script>
		<script type = "text/javascript" src = "/EmployeeManagementSite/JavaScript/commonmethod.js"></script>
	</head>
	<body>
		<div class = "top">
			<p>ユーザー情報</p>
		</div>
		<div class = "topspace1"></div>
		<div class = "leftspace3">
			<a href = "/EmployeeManagementSite/JSP/menu.jsp">メニューへ</a>
		</div>
		<div class = "leftspace1">
			<table class = "commontable">
				<tr>
					<td>userid</td>
					<td><input type = "text" id = "input1" name = "userid"  class = "displaydata" value = "ダミー1" disabled></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type = "text" id = "input2" name = "password" class = "displaydata" value = "ダミー2" disabled></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type = "text" id = "input3" name = "name" class = "displaydata" value = "ダミー3" disabled></td>
				</tr>
			</table>
		</div>
	</body>
</html>
