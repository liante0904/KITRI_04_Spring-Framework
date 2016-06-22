package member;

import java.util.List;

public interface Dao {
	void insert(Member m); // 가입
	Member select(int num); // 로그인
	void update(Member m); //전화번호 이메일 수정 가능
	void delete(int num); // 탈퇴
	List SelectAll();
	
}
