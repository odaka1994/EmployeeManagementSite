var userid,pass,name;

//HTMLの読み込み完了後に起動
document.addEventListener("load", init(), false);

function init(){
	//形式key1=value1;key2=value2;....
	var cookies = document.cookie;
	var cookiesArray = cookies.split(';');
	var cArray;
	
	//IE11では拡張for非対応な為for文で対応
	for(var i =0; i < cookiesArray.length; i++){
		
	    cArray = cookiesArray[i].split('=');
	    switch( cArray[0].replace(/\s+/g, "") ){
	    case "userid":
	    	userid = cArray[1].replace(/\s+/g, "");
        	break;
	    case "pass":
	    	pass = cArray[1].replace(/\s+/g, "");
        	break;
	    case "name":
	    	name = cArray[1].replace(/\s+/g, "");
	    	break;
	    default:
	        break;
	    }
	}
	
	//IE11ではdefaultValueが非対応な為valueで対応	
	document.getElementById("input1").value = userid;
	document.getElementById("input2").value = pass;
	document.getElementById("input3").value = name;
	}
