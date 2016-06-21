package com.kitri.aa;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("memService")
public class MemberDAOService implements MemberDAO {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public ArrayList<Member> getMembers() {
		// TODO Auto-generated method stub
		ArrayList<Member> result = new ArrayList<Member>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.getMembers();
		return result;
	}

	@Override
	public Member getMember(int num) {
		// TODO Auto-generated method stub
		Member m = new Member();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		m = memberMapper.getMember(num);
		return m;
	}

	@Override
	public void insertMember(Member member) {
		// TODO Auto-generated method stub
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember(member);
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.updateMember(member);
	}

	@Override
	public void deleteMember(int num) {
		// TODO Auto-generated method stub
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(num);
	}

}
