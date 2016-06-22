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
		return "form"; // form.do�� ȣ���ϸ� /view/form.jsp�� �̵��ϰ� �ȴ�
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
		//modelatrribue�� ����ϸ� ������ ��ü�� Ŭ�����̸�(member)�� �ƴ� attribute���� ������ ��ü�̸����� ��ȯ�ȴ�.
		//�� test.jsp���� x��� �̸����� ��ü�� �ޱ⶧���� x�� ����Ѵ�.
		service.addMember(m);
		return "test"; // Ŭ���� �̸����� ��ü�� �ڵ����� �Ѿ�� �ȴ�.
		
		//return "redirect:list.do"; 
		}
	
}
