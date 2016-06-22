package ModelAtrributeTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameSearchController {
	@ModelAttribute("searchTypeList")
	// �� �ڵ忡�� @ModelAttribute ������̼��� ����� referenceSearchTypeList() �޼��尡 ������ �� ��ü�� "searchTypeList"��� �̸����� �信 ���޵ȴ�.
	public List<SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "��ü"));
		options.add(new SearchType(2, "������"));
		options.add(new SearchType(3, "ĳ����"));
		return options;
	}
	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList(){
		return new String[] {"�ٵ�", "�Ͻ�����", "������ġ"};
	}

	@RequestMapping("/main.do")
	public String main(){
		return "main";
	}
}
