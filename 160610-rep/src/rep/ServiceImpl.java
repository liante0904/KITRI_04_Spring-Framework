package rep;

import java.util.List;

public class ServiceImpl implements Service {

	
	private Dao dao;
	
	public ServiceImpl(){
		dao = new DaoImpl();
	}
	
	@Override
	public int addRep(Reply r) {
		// TODO Auto-generated method stub
		return dao.insert(r);
	}

	@Override
	public Reply getRep(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public int editRep(Reply r) {
		// TODO Auto-generated method stub
		return dao.update(r);
	}

	@Override
	public int delRep(int num) {
		// TODO Auto-generated method stub
		return dao.delete(num);
	}

}
