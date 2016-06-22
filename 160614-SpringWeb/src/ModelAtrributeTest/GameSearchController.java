package ModelAtrributeTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameSearchController {
	@ModelAttribute("searchTypeList")
	// 이 코드에서 @ModelAttribute 어노테이션이 적용된 referenceSearchTypeList() 메서드가 리턴한 모델 객체는 "searchTypeList"라는 이름으로 뷰에 전달된다.
	public List<SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "아이템"));
		options.add(new SearchType(3, "캐릭터"));
		return options;
	}
	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList(){
		return new String[] {"바둑", "하스스톤", "오버워치"};
	}

	@RequestMapping("/main.do")
	public String main(){
		return "main";
	}
}
