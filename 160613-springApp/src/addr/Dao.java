package addr;

import java.util.List;

public interface Dao {

	String insert(Member m);
	
	Member select(int num);
	
	List selectAll();
	
	int update(Member m);
	
	int delete(int num);
}
