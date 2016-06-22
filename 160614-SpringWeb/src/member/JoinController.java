package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}
	@RequestMapping(value="join/join.do")
	public String join(Join j){
		service.addJoin(j);
		return "join/loginForm";
	}
	@RequestMapping(value="join/idCheck.do")
	public ModelAndView idCheck(@RequestParam(value="id")String id){
		Join j = service.getJoin(id);
		boolean flag = false;
		if (j==null) {
			flag = true;
		}
		ModelAndView mav = new ModelAndView("join/check");
		mav.addObject("flag", flag);
		return mav;
	}
	@RequestMapping(value="join/login.do")
	public String login(Join j, HttpServletRequest req){
		HttpSession session;
		String result ="join/loginForm";
		boolean flag = service.login(j);
		if (flag ==true) {
			System.out.println("로그인 성공");
			session = req.getSession();
			session.setAttribute("id", j.getId());
			result = "join/main";
		}else{
			System.out.println("로그인 실패");	
		}
		return result;
		
	}
	@RequestMapping(value="join/out.do")
	public String out(HttpSession session){
		session.getAttribute("id");
		System.out.println();
		 service.delJoin((String) session.getAttribute("id"));
		String result ="join/main";
		System.out.println("탈퇴성공");
		return result;
	}
	@RequestMapping(value="join/logout.do")
	public String logout(HttpSession session){
		
		System.out.println(session.getAttribute("id"));
				
		String result ="join/loginForm";
		System.out.println("로그아웃 성공");
		session.invalidate();
		return result;
	}
	@RequestMapping(value="/join/editForm.do")
	public String editForm(){
		

		String result ="join/editForm";
		System.out.println("수정이동성공");
		
		return result;
	}
	@RequestMapping(value="/join/editjoin.do")
	public String editjoin(Join j){
		
		System.out.println(j.getId());
				service.editJoin(j);
		String result ="join/editForm";
		System.out.println("수정하러왔음");
		
		return result;
	}
}
