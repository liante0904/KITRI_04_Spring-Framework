package com.kitri.myapp.member;

public interface JoinMapper {
	void insert(Join j);

	Join select(String id);

	void update(Join j);

	void delete(String id);
}
