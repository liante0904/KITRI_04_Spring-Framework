package imgBoard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	

	// 비동기 코드
	@RequestMapping(value = "/imgBoard/writeRep.do")
	public ModelAndView writeRep(ImgRep ir){
		ModelAndView mav = new ModelAndView("imgBoard/writeRep");
		System.out.println(ir.getContent());
		repService.addRep(ir); //댓글 추가
		ArrayList<ImgRep> list = repService.getAll(ir.getImgNum());
		// 해당 이미지의 댓글만 db에서 받아 json으로 받아온다.
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/imgBoard/deleteRep.do")
	public ModelAndView deleteRep(@RequestParam(value="num") int num){
		ModelAndView mav = new ModelAndView("/imgBoard/writeRep");
		int imgNum = repService.getRep(num).getImgNum();
		repService.delImgrep(num); // 댓글 삭제
		ArrayList<ImgRep> list = repService.getAll(imgNum);
		mav.addObject("list", list);
		return mav;
	}
	
	
}
