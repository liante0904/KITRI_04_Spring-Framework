package com.kitri.myapp.member;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("joinService")
public class ServiceImpl implements Service {

	
	@Resource(name="sqlSession")
	private SqlSession SqlSession;
	
	
	
	void setSqlSession(SqlSession sqlSession) {
		SqlSession = sqlSession;
	}

	@Override
	public void addJoin(Join j) {
		// TODO Auto-generated method stub
		JoinMapper joinmapper = SqlSession.getMapper(JoinMapper.class);
		joinmapper.insert(j);
	}

	@Override
	public Join getJoin(String id) {
		// TODO Auto-generated method stub
		JoinMapper joinMapper = SqlSession.getMapper(JoinMapper.class);
		return joinMapper.select(id);
	}

	@Override
	public boolean login(Join j) {
		// TODO Auto-generated method stub
		
		Join y = getJoin(j.getId());
		if (y != null && y.getPwd().equals(j.getPwd())) {
			return true;
		}
		return false;
	}

	@Override
	public void editJoin(Join j) {
		// TODO Auto-generated method stub
		JoinMapper joinMapper = SqlSession.getMapper(JoinMapper.class);
		joinMapper.update(j);
	}

	@Override
	public void delJoin(String id) {
		// TODO Auto-generated method stub
		JoinMapper joinMapper = SqlSession.getMapper(JoinMapper.class);
		joinMapper.delete(id);
	}

}
