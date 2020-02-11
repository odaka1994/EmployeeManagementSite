

//空白削除
function deleteBlank(targetvalue){
	
	targetvalue = targetvalue.replace(/\s+/g, "");
    return targetvalue
}


function goto(){
	document.location.href = gotopage;
}

