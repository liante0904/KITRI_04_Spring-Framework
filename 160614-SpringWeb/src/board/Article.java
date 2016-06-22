package board;

import java.sql.Date;

public class Article {
	
	private int num;
	
	private Date w_date;
	private String title;
	private String Writer;
	private String content;
	private int parent;
	public Article(){}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public Article(int num, Date w_date, String title, String writer, String content, int parent) {
		super();
		this.num = num;
		this.w_date = w_date;
		this.title = title;
		this.Writer = writer;
		this.content = content;
		this.parent = parent;
	}
	
	
	
	
}
