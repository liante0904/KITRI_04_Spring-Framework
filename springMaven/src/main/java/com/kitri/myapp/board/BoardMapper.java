package com.kitri.myapp.board;

import java.util.List;

public interface BoardMapper {
	void insert(Article a);
	Article select(int num);
	List selectAll();
	List selectByParentNum(int parentNum);
	void update(Article a);
	void delete(int num);
	List selectByWriter(String writer);
	List selectByTitle(String title);
}
