package download;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {
	private String base_path = "C:/upload/";
	@RequestMapping("/fileList.do")
	public ModelAndView fileList(){
		List<File> listFile = new ArrayList<File>();
		File dir = new File(base_path);
		File[] files = dir.listFiles(); // files 배열에 파일들의 리스트를 배열로 담는다.
		if (null != files) { // files 배열에 데이터가 있을 경우
			for (File f: files) {  // files에 담긴 데이터를 출력한다 (향상된 for문)
				if (f.isFile()) { 
					listFile.add(f);
				}
			} 
		}
		return new ModelAndView("down/fileList", "list", listFile);
	}
	@RequestMapping("/file.do")
	public ModelAndView download(@RequestParam(value="name") String name) throws Exception{
		File downloadFile = new File(base_path+name);
		return new ModelAndView("download", "downloadFile", downloadFile);
	}
}
