package com.kitri.myapp.board;

import java.util.List;

public interface Service {
	void WriteArticle(Article a);
	Article getArticleByNum(int num);
	List getArticleRoot();
	List getArticleByParentNum(int parentNum);
	void editArticle(Article a);
	void delArticle(int num);
	List getArticleByWriter(String writer);
	List getArticleByTitle(String title);
}
