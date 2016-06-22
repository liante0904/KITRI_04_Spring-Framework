package ModelAtrributeTest;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	/*@RequestMapping(value="/test/test1.do")
	public String test1(Map<String, String> m){
		m.put("data1", "kkk");
		m.put("data2", "ccc");
		return "test1";
	}
	*/
	
	@RequestMapping(value="/test/test1.do")
	public Model test1(Model m){
		m.addAttribute("data1", "kkk");
		m.addAttribute("data2", "ccc");
		return m;
	}
	
	
	@RequestMapping(value="/test/test2.do")
	public String test2(Map<String, String> m){
		ModelAndView mav = new ModelAndView("test2");
		return "test2";
	}
}
