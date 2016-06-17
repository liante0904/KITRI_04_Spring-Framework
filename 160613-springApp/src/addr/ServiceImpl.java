package addr;

import java.util.List;

public class ServiceImpl implements Service {

	private Dao dao;

	
	public void setDao(Dao dao) {  // 스프링 프로퍼티 설정 (setter)
		this.dao = dao;
	}

	public ServiceImpl(Dao dao){
		this.dao = dao;
	}
	public ServiceImpl() {
	}

	@Override
	public void addMember(Member m) {
		dao.insert(m);
	}

	@Override
	public Member getMember(int num) {
		return dao.select(num);
	}

	@Override
	public List<Member> getMembers() {
		return dao.selectAll();
	}

	@Override
	public void editMember(Member m) {
		dao.update(m);
	}

	@Override
	public void delMember(int num) {
		dao.delete(num);
	}

}