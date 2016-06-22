package member;

import java.util.ArrayList;
import java.util.List;

public class SerivceImpl implements Service {

	DaoImpl dao = new DaoImpl();

	public void ServiceImpl(){}
	
	@Override
	public void addMember(Member m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public Member getMember(int num) {
		// TODO Auto-generated method stub
		Member mem = dao.select(num);
		return mem;
	}

	@Override
	public boolean login(int num, String name) {
		// TODO Auto-generated method stub
		DaoImpl dao = new DaoImpl();
		Member mem = new Member();

		mem = dao.select(num);
		int db_num = mem.getNum(); // db num 
		String db_name = mem.getName(); // db name
		
		System.out.println("db_num: "+db_num+" //db_name: "+db_name);
		if (num == db_num && name.equals(db_name)) { 
			return true;
		} else{
			return false;
		}
	}

	@Override
	public void editInfo(Member m) {
		// TODO Auto-generated method stub
		dao.update(m);

	}

	@Override
	public void delMember(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);

	}
	public List<Member> allMember() {
		List<Member> list = new ArrayList<Member>();
		list = dao.SelectAll();
		return list;
				
	}

}
