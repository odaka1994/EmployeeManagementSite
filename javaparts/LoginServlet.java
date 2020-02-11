package javaparts;

import static javaparts.CommonData.*;
import static javaparts.CommonMethod.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				    throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		//全角文字の文字化け対策
		request.setCharacterEncoding("UTF-8");
		
		String userid = HalfSizeAndDeleteBlank(request.getParameter("userid"));
		String pass = HalfSizeAndDeleteBlank(request.getParameter("password"));
		String gotopage = "/JSP/loginerror.jsp";
		
		SQLParts SQLP = new SQLParts(URL, USERNAME, PASSWORD,tableName);
		String data = SQLP.getData(userid,pass);
		SQLP.closeMySQL();
		
		if (data.length() != 0){
			//該当データあり
			gotopage = "/JSP/menu.jsp";
			String[] arydata = data.split(","); 
			String name =arydata[2];
			saveCookie(request,response,userid,pass,name);
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(gotopage);
		dispatch.forward(request, response);
	}
}
