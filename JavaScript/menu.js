
var gotopage = "/EmployeeManagementSite/JSP/";

function displaydata(){
	gotopage = gotopage + "displaydata.jsp";
	goto();
}

function changedata(){
	gotopage = gotopage + "changedata.jsp";
	goto();
}


function isDelete(){
	var ret = confirm("データを削除します。\nよろしいですか？");
	
	if (ret == true){
		return true;
	}else{
		alert("キャンセルしました。");
		return false;
	}
	
}

