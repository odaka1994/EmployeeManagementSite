<html lang="ja">
	<%@ page contentType="text/html; charset=UTF-8" %>
	<title>登録</title>
	<head>
		
		<link rel="stylesheet" type="text/css" href="/EmployeeManagementSite/CSS/style.css">
		<script type = "text/javascript" src = "/EmployeeManagementSite/JavaScript/createdata.js" defer></script>
	</head>
	
	
	
	<body>
		
		<div class = "top">
			<p>登録</p>
		</div>
		
		<div class = "topspace1"></div>
		
		<div class = "leftspace3">
			<a href = "/EmployeeManagementSite/JSP/login.jsp">ログインへ</a>
		</div>
		
		
		<form action = "/EmployeeManagementSite/CreateServlet" method = "post">
			
			<div class = "leftspace1">
				<table class = "commontable">
					<tr>
						<td>userid</td>
						<td><input type = "text" id = "input1" name = "userid" size = "30" maxlength = "10"></td>
					</tr>
					
					<tr>
						<td>password</td>
						<td><input type = "password" id = "input2" name = "password" size = "30" maxlength = "20"></td>
					</tr>
					
					<tr>
						<td>name</td>
						<td><input type = "text" id = "input3" name = "name" size = "30" maxlength = "10"></td>
					</tr>
				</table>
				
			</div>
			
			<div class = "leftspace3">
				<input type = "submit" name = "register" class = "commonbutton" onclick = "return isCheck()" value = "登録">
			</div>
			
		</form>
		
	</body>
	
</html>