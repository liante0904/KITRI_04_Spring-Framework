package rep;

import java.util.List;

public interface Service {
	int addRep(Reply r);
	Reply getRep(int num);
	List getAll();
	int editRep(Reply r);
	int delRep(int num);
}
