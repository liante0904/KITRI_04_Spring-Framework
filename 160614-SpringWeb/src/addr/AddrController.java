package addr;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddrController {
	private Service service;
	public AddrController() {
		// TODO Auto-generated constructor stub
	}
	public void setService(Service service) {
		this.service = service;
	}
	@RequestMapping(value="/form.do")
	String form(){
		return "form"; // form.do를 호출하면 /view/form.jsp로 이동하게 된다
	}
	
	@RequestMapping(value="/list.do")
	ModelAndView list(){
		ModelAndView mav = new ModelAndView("list");
		ArrayList<Member> list = (ArrayList<Member>) service.getMembers();
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value="/addMember.do")
	String addMember(@ModelAttribute("read")Member m){ 
		//modelatrribue를 사용하면 생성된 객체가 클래스이름(member)가 아닌 attribute에서 지정한 객체이름으로 반환된다.
		//즉 test.jsp에서 x라는 이름으로 객체를 받기때문에 x로 사용한다.
		service.addMember(m);
		return "test"; // 클래스 이름으로 객체가 자동으로 넘어가게 된다.
		
		//return "redirect:list.do"; 
		}
	
}
