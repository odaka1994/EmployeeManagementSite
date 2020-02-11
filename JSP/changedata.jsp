<html lang="ja">
	<%@ page contentType="text/html; charset=UTF-8" %>
	<title>情報変更</title>
	<head>
		<link rel="stylesheet" type="text/css" href="/EmployeeManagementSite/CSS/style.css">
		<script type = "text/javascript" src = "/EmployeeManagementSite/JavaScript/changedata.js"></script>
	</head>
	<body>
		<div class = "top">
			<p>情報変更</p>
		</div>
		<div class = "topspace1"></div>
		<div class = "leftspace3">
			<a href = "/EmployeeManagementSite/JSP/menu.jsp">メニューへ</a>
		</div>
		<form action = "/EmployeeManagementSite/ChangeServlet" method = "post">
			<div class = "leftspace1">
				<table class = "commontable">
					<tr>
						<td>password</td>
						<td><input type = "text" id = "input1" name = "password" size = "30" maxlength = "20"></td>
					</tr>
					<tr>
						<td>name</td>
						<td><input type = "text" id = "input2" name = "name" size = "30" maxlength = "20"></td>
					</tr>
				</table>
			</div>
			<div class = "leftspace3">
				<input type = "submit" name = "login" class = "commonbutton" onclick = "return isCheck()" value = "変更">
			</div>
			<div class = "leftspace1">
				<p class = "changemsg" id = "chgmsg">ユーザー情報を変更しました。</p>
			</div>
		</form>
	</body>
</html>
