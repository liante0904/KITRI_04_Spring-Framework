package test;


import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] config = new String[]{"config.xml"}; // xml������ config �迭�� ��´�
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config); // �����̳� �����Ͽ� config �迭�� ���ڷ� ����
		// ��ü�� �����Ͽ� �޸� pool�� �ִ´�.
		
	/*	SayHello s = (SayHello)context.getBean("myBean"); // mybean ��ü�� �����´�. objectŸ���̹Ƿ� �ٿ� ĳ������ �Ѵ�. 
		s.printMsg();
*/
		PropTest s = (PropTest) context.getBean("PropTest");
		s.printInfo();
	}

}
