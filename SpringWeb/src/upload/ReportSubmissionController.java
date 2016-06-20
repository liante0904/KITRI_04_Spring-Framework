package upload;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportSubmissionController {
	// jsp submit -> to ��Ʈ�ѷ� -> �й�, ������ �޴´�
	// ���� ���ϸ��� ��θ� �ڸ��� ���ϸ� ��ü�� ���� ��, upload�������� ������ ������ ������.
	
	
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
