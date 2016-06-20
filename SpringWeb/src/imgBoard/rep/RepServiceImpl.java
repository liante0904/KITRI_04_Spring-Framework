
package imgBoard.rep;

import java.util.ArrayList;

public class RepServiceImpl implements RepService {

	private RepDao dao;
	
	public void setDao(RepDao dao) {
		this.dao = dao;
	}

	@Override
	public void addRep(ImgRep ir) {
		// TODO Auto-generated method stub
		dao.insert(ir);
	}

	@Override
	public ImgRep getRep(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public ArrayList<ImgRep> getAll(int imgNum) {
		// TODO Auto-generated method stub
		return dao.selectAll(imgNum);
	}

	@Override
	public void delImgrep(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
