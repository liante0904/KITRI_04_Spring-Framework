package com.kitri.myapp.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class JoinController {
	
	@Resource(name="joinService")
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}
	//서버 실행시 loginform
		@RequestMapping(value = "/")
		public String server_root(Join j) {
			return "join/loginForm";
		}
	
	//로그인 폼 이동
	@RequestMapping(value = "/join/loginForm.do")
	public String loginForm(Join j) {
		return "join/loginForm";
	}
	
	//회원가입 폼 이동
	@RequestMapping(value = "/join/joinForm.do")
	public String joinForm(Join j) {
		return "join/joinForm";
	}
	
	//회원가입 전송(db반영)
	@RequestMapping(value = "/join/join.do")
	public String join(Join j) {
		service.addJoin(j);
		return "join/loginForm";
	}
	

	// 로그인 버튼 클릭(동작)
	@RequestMapping(value = "/join/login.do")
	public String login(Join j, HttpServletRequest req) {
		HttpSession session = null;

		boolean flag = service.login(j);
		if(flag){
			session = req.getSession();
			session.setAttribute("id", j.getId());
			//return	"join/main";
			return	"join/main";
		}else {
		return "join/loginForm";
	}
	}
	
	// 회원가입 페이지 아이디 중복 구현
	@RequestMapping(value = "/join/idCheck.do")
	public ModelAndView idCheck(@RequestParam(value = "id") String id) {
		
		Join j = service.getJoin(id);
		boolean flag = false;
		if (j == null) {
			flag = true;
		}
		ModelAndView mav = new ModelAndView("join/check");
		mav.addObject("flag", flag);
		return mav;
	}
	
	
}






