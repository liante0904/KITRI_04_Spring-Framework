package board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}

	@RequestMapping(value = "/board/write.do")
	public String write(Article a){
		service.WriteArticle(a);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value = "/board/list.do")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("board/list");
		ArrayList<Article> list = 
				(ArrayList<Article>) service.getArticleRoot();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/board/read.do")
	public ModelAndView read(@RequestParam(value="num")int num){
		ModelAndView mav = new ModelAndView("board/editForm");
		Article a = service.getArticleByNum(num);
		ArrayList<Article> reps = 
		(ArrayList<Article>) service.getArticleByParentNum(num);
		mav.addObject("a", a);
		mav.addObject("reps", reps);
		return mav;
	}
	
	@RequestMapping(value = "/board/preview.do")
	public ModelAndView preview(@RequestParam(value="num")int num){
		ModelAndView mav = new ModelAndView("board/readResult");
		Article a = service.getArticleByNum(num);
		mav.addObject("a", a);
		return mav;
	}
	
	@RequestMapping(value = "/board/edit.do")
	public String edit(Article a){
		service.editArticle(a);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value = "/board/del.do")
	public String del(@RequestParam(value="num")int num){
		service.delArticle(num);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value = "/board/searchById.do")
	public ModelAndView searchById(
			@RequestParam(value="writer")String writer){
		ModelAndView mav = new ModelAndView("board/searchResult");
		ArrayList<Article> list = 
		(ArrayList<Article>) service.getArticleByWriter(writer);
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/board/searchByTitle.do")
	public ModelAndView searchByTitle(
			@RequestParam(value="title")String title){
		ModelAndView mav = new ModelAndView("board/searchResult");
		ArrayList<Article> list = 
		(ArrayList<Article>) service.getArticleByTitle(title);
		mav.addObject("list", list);
		return mav;
	}
}
