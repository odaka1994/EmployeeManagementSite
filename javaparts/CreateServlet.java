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

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreateServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				    throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		//全角文字の文字化け対策
		request.setCharacterEncoding("UTF-8");		
		
		//半角化・空白削除
		String userid = HalfSizeAndDeleteBlank(request.getParameter("userid"));
		String pass = HalfSizeAndDeleteBlank(request.getParameter("password"));
		String name = HalfSizeAndDeleteBlank(request.getParameter("name"));
		
		String gotopage = "";
		SQLParts SQLP = new SQLParts(URL, USERNAME, PASSWORD,tableName);
		String data = SQLP.getData(userid,pass);
		if (data.length() != 0){
			//該当データが存在する場合、エラーとする
			gotopage = "/JSP/createdataerror.jsp"; 
		}else{
			gotopage = "/JSP/createcomplete.jsp";
			SQLP.insertData(userid, pass, name);
			saveCookie(request,response,userid,pass,name);
		}
		
		SQLP.closeMySQL();
		
		RequestDispatcher dispatch = request.getRequestDispatcher(gotopage);
		dispatch.forward(request, response);
	}
}
