package board;

import java.util.ArrayList;
import java.util.List;

public interface Service {

	
	void WriteArticle(Article a);
	Article getArticleBynum(int num);
	List getArticleRoot();
	List getArticleByParentNum(int parentNum);
	void editArticle(Article a);
	void delArticle(int num);
	List getArticleByWriter(String writer);
	List getArticleByTitle(String title);
}
