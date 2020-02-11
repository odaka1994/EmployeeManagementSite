var userid,pass,name;

//HTMLの読み込み完了後に起動
document.addEventListener("load", init(), false);

function init(){
	//形式key1=value1;key2=value2;....
	var cookies = document.cookie;
	var cookiesArray = cookies.split(';');
	var cArray;
	
	for(var c of cookiesArray){
		
	    cArray = c.split('=');
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
	
	document.getElementById("input1").defaultValue = userid;
	document.getElementById("input2").defaultValue = pass;
	document.getElementById("input3").defaultValue = name;
	
	}

