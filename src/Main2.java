
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/Main")
public class Main2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		System.out.println(request.getParameter("keyword"));
		if(request.getParameter
				("keyword") == null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search2.jsp").forward(request, response);
			return;
		}
		
		//以下為ArrayList的方法
		
		if (request.getParameter("type").equals("Sports")) {
			Query2 query = new Query2(request.getParameter("keyword"));
			String[][] s = query.initialQuery(1);
			request.setAttribute("q", s);
		}
		else if(request.getParameter("type").equals("Politics")) {
			Query2 query = new Query2(request.getParameter("keyword"));
			String[][] s = query.initialQuery(2);
			request.setAttribute("q", s);
		}
		
		
		
		
		//以下為HashMap用法
		/*if (request.getParameter("type").equals("Sports")) {
			
			Query query = new Query(request.getParameter("keyword"));
			HashMap<String, String> q = query.initialQuery(1);
			
			String[][] s = new String[q.size()][2];
			request.setAttribute("q", s);
			int num = 0;
			for(Entry<String, String> entry : q.entrySet()) {
			    String key = entry.getKey();
			    String value = entry.getValue();
			    s[num][0] = key;
			    s[num][1] = value;
			    num++;
			}
			
		}
		else if(request.getParameter("type").equals("Politics")) {
			
			Query query = new Query(request.getParameter("keyword"));
			HashMap<String, String> q = query.initialQuery(2);
			
			String[][] s = new String[q.size()][2];
			request.setAttribute("q", s);
			int num = 0;
			for(Entry<String, String> entry : q.entrySet()) {
			    String key = entry.getKey();
			    String value = entry.getValue();
			    s[num][0] = key;
			    s[num][1] = value;
			    num++;
			}
			
		}
		*/
		
		
		
		request.getRequestDispatcher("googleitem2.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}