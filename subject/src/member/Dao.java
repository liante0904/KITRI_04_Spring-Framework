package member;

import java.util.List;

public interface Dao {
	void insert(Member m); // ����
	Member select(int num); // �α���
	void update(Member m); //��ȭ��ȣ �̸��� ���� ����
	void delete(int num); // Ż��
	List SelectAll();
	
}
