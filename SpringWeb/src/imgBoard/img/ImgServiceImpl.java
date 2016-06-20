package imgBoard.img;

import java.util.ArrayList;

public class ImgServiceImpl implements ImgService {

	private ImgDaoImpl dao;
	
	

	public void setDao(ImgDaoImpl dao) {
		this.dao = dao;
	}

	
	@Override
	public void AddImg(Img i) {
		// TODO Auto-generated method stub
		dao.insert(i);
	}

	@Override
	public Img getImg(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public ArrayList<Img> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void delImg(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
