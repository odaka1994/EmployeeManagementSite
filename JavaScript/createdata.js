function isCheck(){
	var userid,pass,name;
	userid = deleteBlank(document.getElementById("input1").value);
	pass = deleteBlank(document.getElementById("input2").value);
	name = deleteBlank(document.getElementById("input3").value);
	
	if (userid == "" || pass == "" || name == ""){
		alert("入力項目は全て必須です。");
		return false
	}else{
		return true
	}
	
}
