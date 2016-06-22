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
	//���� ����� loginform
		@RequestMapping(value = "/")
		public String server_root(Join j) {
			return "join/loginForm";
		}
	
	//�α��� �� �̵�
	@RequestMapping(value = "/join/loginForm.do")
	public String loginForm(Join j) {
		return "join/loginForm";
	}
	
	//ȸ������ �� �̵�
	@RequestMapping(value = "/join/joinForm.do")
	public String joinForm(Join j) {
		return "join/joinForm";
	}
	
	//ȸ������ ����(db�ݿ�)
	@RequestMapping(value = "/join/join.do")
	public String join(Join j) {
		service.addJoin(j);
		return "join/loginForm";
	}
	

	// �α��� ��ư Ŭ��(����)
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
	
	// ȸ������ ������ ���̵� �ߺ� ����
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






