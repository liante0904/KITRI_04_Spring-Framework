package member;

public class ServiceImpl implements Service {

	private Dao dao;

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void addJoin(Join j) {
		// TODO Auto-generated method stub
		dao.insert(j);
	}

	@Override
	public Join getJoin(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
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
		dao.update(j);
	}

	@Override
	public void delJoin(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
