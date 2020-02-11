

function isCheck(){
	
	var pass,name;
	pass = document.getElementById("input1").value.replace(/\s+/g, "");
	name = document.getElementById("input2").value.replace(/\s+/g, "");
	
	//alert (pass + "：" + name);
	
	if (pass == "" && name == ""){
		alert("パスワードまたは名前を入力してください。");
		return false
	}else{
		return true
	}
	
}

