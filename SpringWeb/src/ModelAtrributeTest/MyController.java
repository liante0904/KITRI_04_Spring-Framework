package ModelAtrributeTest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="/test/test1.do")
	public Map test1(){
		Map m = new HashMap();
		m.put("data1", "aaa");
		m.put("data2", "bbb");
		return m;
	}
	
	@RequestMapping(value="/test/test2.do")
	public ModelAndView test2(){
		ModelAndView mav = new ModelAndView("test2");
		mav.addObject("data2", "test2");
		return mav;
	}
}
