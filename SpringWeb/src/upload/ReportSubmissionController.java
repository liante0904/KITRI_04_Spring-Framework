package upload;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportSubmissionController {
	// jsp submit -> to 컨트롤러 -> 학번, 파일을 받는다
	// 받은 파일명에서 경로를 자르고 파일명만 객체에 담은 뒤, upload폴더같은 보관할 곳으로 보낸다.
	
	
	@RequestMapping(value = "/report/submitReport3.do")
	public String submitReport3(ReportCommand reportCommand){
		String fileName = reportCommand.getReport().getOriginalFilename();
		String path = "C:\\Users\\Administrator\\Dropbox\\Developer\\Workspace\\Network\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\" + fileName;
		File f = new File(path);
		try{
			reportCommand.getReport().transferTo(f);
		} catch (IllegalStateException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/report/imgList.do";
	}
	
	
	@RequestMapping(value = "/report/imgList.do")
	public ModelAndView imgList(){
		ModelAndView mav = new ModelAndView("report/submissionComplete");
		File dir = new File("C:\\Users\\Administrator\\Dropbox\\Developer\\Workspace\\Network\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img");
		String[] files = dir.list();

		mav.addObject("files", files);
		return mav;
		
	}
}
