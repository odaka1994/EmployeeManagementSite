package javaparts;

import java.text.Normalizer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonMethod{
	
	
	
	//半角化・空白削除
	public static String HalfSizeAndDeleteBlank(String targetvalue){
		targetvalue = Normalizer.normalize(targetvalue,Normalizer.Form.NFKC);
		targetvalue = targetvalue.replaceAll(" ","");
		
		return targetvalue;
	}
	
	
	//対象クッキーを取得（該当クッキーが存在しない場合、Nullを返却）
	public static Cookie getCookie(HttpServletRequest request,String cookiename){
		Cookie reslutcookie = null;
		Cookie cookie[] = request.getCookies();
		
		if (cookie == null){
			System.out.println("クッキーが存在しない為、強制終了");
			System.exit(0);
		}
		
		for (int i = 0 ; i < cookie.length ; i++){
			//「==」では正常に判断できなかったのでequalsを使用
			if(cookiename.equals(cookie[i].getName())){
				reslutcookie = cookie[i];
				break;
			}
		}
		
		if(reslutcookie == null){
			System.out.println("クッキーを取得することができませんでした。");
		}
		
		return reslutcookie;
	}
	
	//対象クッキーから値を取得（該当クッキーが存在しない場合、空値を返却）
	public static String getCookieValue(HttpServletRequest request,String cookiename){
		String reslutvalue = "";
		Cookie cookie[] = request.getCookies();
		
		if (cookie == null){
			System.out.println("クッキーが存在しない為、強制終了");
			System.exit(0);
		}
		
		for (int i = 0 ; i < cookie.length ; i++){
			//「==」では正常に判断できなかったのでequalsを使用
			if(cookiename.equals(cookie[i].getName())){
				reslutvalue = cookie[i].getValue();
				break;
			}
		}
		
		if(reslutvalue == ""){
			System.out.println("クッキーの値を取得することができませんでした。");
		}
		
		return reslutvalue;
	}
	
	
	//クッキーを保存する（既に存在する場合は値を上書き）
	public static void saveCookie(HttpServletRequest request,HttpServletResponse response,
			String userid,String pass,String name){
		
		Cookie cookie1 = new Cookie("userid", userid);
		Cookie cookie2 = new Cookie("pass", pass);
		Cookie cookie3 = new Cookie("name",name);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
	}
	
	
}

