package imgBoard.img;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import imgBoard.rep.ImgRep;

public class Img {
	private int num;
	private String title;
	private String path;
	private String writer;
	private MultipartFile file;
	
	ArrayList<ImgRep> reps;
	
	public Img(){}

	
	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public Img(int num, String title, String path, String writer) {
		this.num = num;
		this.title = title;
		this.path = path;
		this.writer = writer;
	}


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public ArrayList<ImgRep> getReps() {
		return reps;
	}
	public void setReps(ArrayList<ImgRep> reps) {
		this.reps = reps;
	}
	
}
