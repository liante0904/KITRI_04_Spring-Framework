package com.kitri.myapp.board;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("boardService")
public class ServiceImpl implements Service {
	

	@Resource(name="sqlSession")
	private SqlSession SqlSession;
	
	
	
	void setSqlSession(SqlSession sqlSession) {
		SqlSession = sqlSession;
	}
	
	@Override
	public void WriteArticle(Article a) {
		// TODO Auto-generated method stub
		BoardMapper boardmapper = SqlSession.getMapper(BoardMapper.class);
		boardmapper.insert(a);
	}

	@Override
	public Article getArticleByNum(int num) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = SqlSession.getMapper(BoardMapper.class);
		return boardMapper.select(num);
	}

	@Override
	public List getArticleRoot() {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = SqlSession.getMapper(BoardMapper.class);
		return boardMapper.selectAll();
	}

	@Override
	public List getArticleByParentNum(int parentNum) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = SqlSession.getMapper(BoardMapper.class);
		return boardMapper.selectByParentNum(parentNum);
	}

	@Override
	public void editArticle(Article a) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = SqlSession.getMapper(BoardMapper.class);
		boardMapper.update(a);
	}

	@Override
	public void delArticle(int num) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = SqlSession.getMapper(BoardMapper.class);
		boardMapper.delete(num);
	}

	@Override
	public List getArticleByWriter(String writer) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = SqlSession.getMapper(BoardMapper.class);
		return boardMapper.selectByWriter(writer);
	}

	@Override
	public List getArticleByTitle(String title) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = SqlSession.getMapper(BoardMapper.class);
		return boardMapper.selectByTitle(title);
	}

}
