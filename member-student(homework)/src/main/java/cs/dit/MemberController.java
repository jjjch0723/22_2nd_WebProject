package cs.dit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello World");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String com = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".do"));
		System.out.println(com);
		String viewPage = null; 
		
		if(com != null && com.equals("list")) {
			MemberSerivce service = new MListService();
			service.execute(request, response);
			viewPage = "/WEB-INF/view/list.jsp";
			
		}else if(com != null && com.equals("insertForm")) {
			viewPage = "/WEB-INF/view/insertForm.jsp";
			
		}else if(com != null && com.equals("insert")) {
			MemberSerivce service = new MinsertService();
			service.execute(request, response);
			viewPage = "list.do";
			
		}else if(com != null && com.equals("index")) {
			viewPage = "/WEB-INF/view/index.jsp";
			
		}else if(com != null && com.equals("updateForm")) {
			MemberSerivce service = new MViewService();
			service.execute(request, response);
			viewPage = "/WEB-INF/view/updateForm.jsp";
			
		}else if(com != null && com.equals("update")) {
			MemberSerivce service = new MUpdateService();
			service.execute(request, response);
			viewPage = "list.do";
			
		}
		else if(com != null && com.equals("delete")) {
			MemberSerivce service = new MDeleteService();
			service.execute(request, response);
			viewPage = "list.do";
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		
		System.out.println(viewPage);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
