package ModelAtrributeTest;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.SearchResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameSearchController {
	
	@ModelAttribute("searchTypeList")
	public List<SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "��ü"));
		options.add(new SearchType(2, "������"));
		options.add(new SearchType(3, "ĳ����"));
		return options;
	}

	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList() {
		return new String[] { "����", "âõ2", "�����̵�" };
	}

	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}

}
