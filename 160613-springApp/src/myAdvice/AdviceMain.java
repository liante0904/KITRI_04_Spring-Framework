package myAdvice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] config = new String[]{"config.xml"}; // xml������ config �迭�� ��´�
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config); // �����̳� �����Ͽ� config �迭�� ���ڷ� ����
		AdviceTest a = (AdviceTest) context.getBean("adviceTest");
		a.test1();
		a.test2();
		a.test3();

	}

}
