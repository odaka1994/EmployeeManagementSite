

function isCheck(){
	
	var userid,pass;
	userid = deleteBlank(document.getElementById("input1").value);
	pass = deleteBlank(document.getElementById("input2").value);
	
	//alert (userid + "：" + pass);
	
	if (userid == "" && pass == ""){
		alert("ユーザーIDとパスワードを入力してください。");
		return false
	}else{
		return true
	}
	
}

