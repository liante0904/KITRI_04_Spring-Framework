package board;

import java.util.List;

public class ServiceImpl implements Service {

	
	


	public void setDao(Dao dao) {
		this.dao = dao;
	}

	private Dao dao;
	
	@Override
	public void WriteArticle(Article a) {
		// TODO Auto-generated method stub
		dao.insert(a);
	}

	@Override
	public Article getArticleBynum(int num) {
		// TODO Auto-generated method stub

		return dao.select(num);
	}

	@Override
	public List getArticleRoot() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List getArticleByParentNum(int parentNum) {
		// TODO Auto-generated method stub
		return dao.selectByParentNum(parentNum);
	}

	@Override
	public void editArticle(Article a) {
		// TODO Auto-generated method stub
		dao.update(a);
	}

	@Override
	public void delArticle(int num) {
		dao.delete(num);

	}

	@Override
	public List getArticleByWriter(String writer) {
		// TODO Auto-generated method stub
		return dao.selectByWriter(writer);
	}

	@Override
	public List getArticleByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.selectByTitle(title);
	}

}
