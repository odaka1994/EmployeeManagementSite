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

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MenuServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie[] = request.getCookies();
		
		if (cookie == null){
			System.out.println("クッキーが存在しない為、強制終了");
			System.exit(0);
		}
		
		String userid = getCookieValue(request,"userid");
		String pass = getCookieValue(request, "pass");
		SQLParts SQLP = new SQLParts(URL, USERNAME, PASSWORD,tableName);
		SQLP.deleteData(userid, pass);
		SQLP.closeMySQL();
		
		String gotopage = "/JSP/login.jsp";
		
		RequestDispatcher dispatch = request.getRequestDispatcher(gotopage);
		dispatch.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
