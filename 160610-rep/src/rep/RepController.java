package rep;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RepController
 */
@WebServlet("/RepController")
public class RepController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RepController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		Service service = new ServiceImpl();
		DaoImpl dao = new DaoImpl();
		response.setCharacterEncoding("euc-kr");
		request.setCharacterEncoding("euc-kr");
		String type = request.getParameter("type");
		String result = "";
		ArrayList<Reply> list = null;
		String name = "";
		String content = "";
		int num = 0;
		Reply r = null;

		if (type.equals("list")) {
			System.out.println("list1");
			list = (ArrayList<Reply>) service.getAll();
			request.setAttribute("list", list);
			result = "rep/list.jsp";
			System.out.println("list2");
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			dispatcher.forward(request, response);
			System.out.println();
		} else if (type.equals("addRep")) {
			name = request.getParameter("name");
			content = request.getParameter("content");
			num = service.addRep(new Reply(0, name, content));
			if (num != 0) {
				r = service.getRep(num);
				request.setAttribute("r", r);
			}
			result = "rep/getRep.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			dispatcher.forward(request, response);
		} else if (type.equals("editRep")) {
			num = Integer.parseInt(request.getParameter("num"));
			name = request.getParameter("name");
			content = request.getParameter("content");

			r = new Reply(num, name, content);
			num = service.editRep(r);
			System.out.println("here@");
			if (num != 0) {
				System.out.println("here@@");
				r = service.getRep(num);
				request.setAttribute("r", r);
				result = "rep/getRep.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(result);
				dispatcher.forward(request, response);
			}
			result = "rep/getRep.jsp";
			request.setAttribute("r", r);
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			dispatcher.forward(request, response);

		} else if (type.equals("delRep")) {
			System.out.println("del");
			num = Integer.parseInt(request.getParameter("num"));
			System.out.println(num);
			num = service.delRep(num);
			boolean flag = false;
			if (num != 0) {
				flag = true;
			}
			request.setAttribute("num", num);
			request.setAttribute("flag", flag);
			result = "rep/resultDel.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			dispatcher.forward(request, response);
		} else if (type.equals("getRep")) {
			System.out.println("here");
			num = Integer.parseInt(request.getParameter("num"));
			r = service.getRep(num);
			request.setAttribute("r", r);
			result = "rep/getRep.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			System.out.println("here3");
			dispatcher.forward(request, response);
		} 
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
