package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/user.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//request.getContextPath("/user.do?reqType=checkId&num=name");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		boolean flag;
		
		Service sc = new SerivceImpl();
		DaoImpl dao = new DaoImpl();
		response.setCharacterEncoding("euc-kr");
		request.setCharacterEncoding("euc-kr");
		ArrayList<Member> list = null;
		String code = "";
		if(request.getParameter("p_code")!=null){
			code = request.getParameter("p_code");
		}
		String reqType = ""; 
		if(request.getParameter("reqType")!=null){
			reqType =  request.getParameter("reqType");
		}
		if(reqType.equals("checkId")){
			int num = 0;
			Member mem = null;
			num = Integer.parseInt(request.getParameter("num")); // 페이지 입력값
			mem = sc.getMember(num);
			System.out.println("중복페이지 입력값" + num);
			
			if (mem.getType()==0) {
				flag = true;
				
			} else {
				flag = false;
			}
			request.setAttribute("flag", flag);
			String url = "check_json.jsp";
			move(request, response, url);
			/*if (mem.getNum() == num) { //입력한 아이디가 중복 일경우 처리
				String url = "check.jsp";
				boolean flag = false;
			
				request.setAttribute("check_id", "1");
				request.setAttribute("flag", flag);
				move(request, response, url);
			}else{ // 중복이 아닐 경우 처리
				String url = "check.jsp";
				boolean flag = true;
				request.setAttribute("check_id", "0");
				request.setAttribute("num", num);
				request.setAttribute("flag", flag);
				move(request, response, url);
				
			}*/

	
		}
		if (code.equals("login_chk")) {
			System.out.println("로그인 버튼 클릭");

			int num = Integer.parseInt(request.getParameter("j_num"));
			String name = request.getParameter("j_name");	//입력값 받기

			System.out.println("num: "+num+"// name: "+name);
			if (sc.login(num, name)) {
				System.out.println("로그인성공");
				String url = "main.jsp";
				request.getSession().setAttribute("num", num);
				move(request, response, url);
			} else {
				System.out.println("로그인실패");
				String url = "index.jsp";
				response.sendRedirect(url);
			}

		} else if(code.equals("join_chk")){
			System.out.println("join bt click");
			System.out.println(request.getParameter("j_name"));
			int num = Integer.parseInt(request.getParameter("j_num"));
			String name = request.getParameter("j_name");
			String email = request.getParameter("j_email");
			String tel = request.getParameter("j_tel");
			String dept = request.getParameter("j_dept");
			int type = Integer.parseInt(request.getParameter("j_type"));
			Member m = new Member(num, name, email, tel, dept, type);
			System.out.println(num + name + email + tel + dept + type);

			sc.addMember(m);
			String url = "index.jsp";
			response.sendRedirect(url);

		} else if(code.equals("logout")){
			System.out.println("logout_bt");
			request.getSession().invalidate();
			String url = "index.jsp";
			response.sendRedirect(url);
		} else if(code.equals("delete")){
			int num = Integer.parseInt(request.getSession().getAttribute("num").toString());
			sc.delMember(num);
			String url = "index.jsp";
			response.sendRedirect(url);
		} else if(code.equals("modify")){
			System.out.println("modify_bt");
			int num = Integer.parseInt(request.getSession().getAttribute("num").toString());
			System.out.println(num);

			Member mem = sc.getMember(num);
			request.setAttribute("MEM", mem);

			String url = "editinfo.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} else if(code.equals("modify_chk")){
			System.out.println("modify_db");

			int num = Integer.parseInt(request.getParameter("j_num"));
			String name = request.getParameter("j_name");
			String email = request.getParameter("j_email");
			String tel = request.getParameter("j_tel");
			String dept = request.getParameter("j_dept");
			int type = Integer.parseInt(request.getParameter("j_type"));
			Member m = new Member(num, name, email, tel, dept, type);
			sc.editInfo(m);
		} else if(reqType.equals("selectAll")){
			System.out.println("!!!!!!");
			list = (ArrayList<Member>) sc.allMember();
			request.setAttribute("list", list);
			String url = "Members.jsp";
			move(request, response, url);
			
		} else if(reqType.equals("json")){
			System.out.println("@@@@");
			list = (ArrayList<Member>) sc.allMember();
			request.setAttribute("list", list);
			String url = "jsonresult.jsp";
			move(request, response, url);
		} else if(code.equals("alluser")){
			System.out.println("!!!!!!");
			list = (ArrayList<Member>) sc.allMember();
			request.setAttribute("list", list);
			String url = "main.jsp";
			move(request, response, url);
		} else if(reqType.equals("alluser_json")){
			System.out.println("@@@@");
			list = (ArrayList<Member>) sc.allMember();
			request.setAttribute("list", list);
			String url = "user_info.jsp";
			move(request, response, url);	
		}
	}

	private void move(HttpServletRequest request, HttpServletResponse response, String url) {
		// TODO Auto-generated method stub
		RequestDispatcher dis = request.getRequestDispatcher(url);
		try {
			dis.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
