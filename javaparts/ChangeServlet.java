package javaparts;

import static javaparts.CommonData.*;
import static javaparts.CommonMethod.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ChangeServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//全角文字の文字化け対策
		request.setCharacterEncoding("UTF-8");
		
		//半角化・空白削除
		String userid = "";
		String oldpass = "";
		String oldname = "";
		
		String newpass = HalfSizeAndDeleteBlank(request.getParameter("password"));
		String newname = HalfSizeAndDeleteBlank(request.getParameter("name"));
		
		//クッキーから現在の情報を取得
		//データベースを更新してもクッキーの値は変更されない為、値を上書き
		//クッキーを上書きするには、まず上書き用のクッキーを作成してaddで追加する
		
		Cookie cookie[] = request.getCookies();
		Cookie overritecookie = null;
		
		if (cookie == null){
			System.out.println("クッキーが存在しない為、強制終了");
			System.exit(0);
		}
		
		userid = getCookieValue(request,"userid");
		oldpass = getCookieValue(request, "pass");
		oldname = getCookieValue(request, "name");
		
		if (newpass != ""){
			overritecookie = getCookie(request,"pass");
			overritecookie.setValue(newpass);
			response.addCookie(overritecookie);
		}
		
		if (newname != ""){
			overritecookie =  getCookie(request,"name");
			overritecookie.setValue(newname);
			response.addCookie(overritecookie);
		}
		
		//データベース更新
		SQLParts SQLP = new SQLParts(URL, USERNAME, PASSWORD,tableName);
		SQLP.updateData(userid,oldpass,newpass,oldname,newname);
		SQLP.closeMySQL();
		
		//postで画面遷移されるので元の画面に戻る
		String gotopage = "/JSP/changedata.jsp";
		RequestDispatcher dispatch = request.getRequestDispatcher(gotopage);
		dispatch.forward(request, response);
	}
}
