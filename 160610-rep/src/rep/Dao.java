package rep;

import java.util.List;

public interface Dao {
	int insert(Reply r);
	
	Reply select(int num);
	
	List selectAll();
	
	int update(Reply r);
	
	int delete(int num);
	
}
