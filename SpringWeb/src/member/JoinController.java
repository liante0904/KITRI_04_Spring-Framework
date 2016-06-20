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

	@RequestMapping(value = "/join/join.do")
	public String join(Join j) {
		service.addJoin(j);
		return "join/loginForm";
	}

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
	
	@RequestMapping(value = "/join/login.do")
	public String login(Join j, HttpServletRequest req) {
		HttpSession session = null;
		String result = "join/loginForm";
		boolean flag = service.login(j);
		if(flag){
			session = req.getSession();
			session.setAttribute("id", j.getId());
			result = "join/main";
		}
		return result;
	}
}






