package imgBoard;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ModelAndView;

import imgBoard.img.Img;
import imgBoard.img.ImgService;
import imgBoard.rep.ImgRep;
import imgBoard.rep.RepService;

@Controller
public class ImgBoardController {
	private ImgService imgService;
	private RepService repService;


	public void setImgService(ImgService imgService) {
		this.imgService = imgService;
	}

	public void setRepService(RepService repService) {
		this.repService = repService;
	}



	@RequestMapping(value = "/imgBoard/add.do")
	public String add(Img i){		
		String fileName = i.getFile().getOriginalFilename(); // 경로를 제외한 파일이름만 담기
		String path = "C:\\Users\\Administrator\\Dropbox\\Developer\\Workspace\\Network\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\" + fileName;
		File f = new File(path);
		try{
			i.getFile().transferTo(f);
		} catch (IllegalStateException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		i.setPath("/img/"+fileName);
		imgService.AddImg(i);	 // 입력받은 객체 db반영
		return "redirect:/imgBoard/list.do";

	}

	@RequestMapping(value = "/imgBoard/list.do")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("/imgBoard/list");
		ArrayList<Img> list = 
				(ArrayList<Img>) imgService.getAll();
		for (int i = 0; i < list.size(); i++) {
			list.get(i) .setReps(repService.getAll(list.get(i).getNum()));
		}
		mav.addObject("list", list);
		return mav;
	}


	@RequestMapping(value = "/imgBoard/delete.do")
	public ModelAndView delete(){
		ModelAndView mav = new ModelAndView("/imgBoard/list");
		ArrayList<Img> list = 
				(ArrayList<Img>) imgService.getAll();
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value = "/imgBoard/addrep.do")
	public String addrep(ImgRep ir){
		repService.addRep(ir);
		return "redirect:/imgBoard/list.do";
	}
	@RequestMapping(value = "/imgBoard/delrep.do")
	public String delrep(int num){
		repService.delImgrep(num);
		return "redirect:/imgBoard/list.do";
	}
}
