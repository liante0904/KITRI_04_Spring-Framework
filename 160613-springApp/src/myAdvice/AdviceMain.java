package myAdvice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] config = new String[]{"config.xml"}; // xml파일을 config 배열에 담는다
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config); // 컨테이너 생성하여 config 배열을 인자로 갖고
		AdviceTest a = (AdviceTest) context.getBean("adviceTest");
		a.test1();
		a.test2();
		a.test3();

	}

}
