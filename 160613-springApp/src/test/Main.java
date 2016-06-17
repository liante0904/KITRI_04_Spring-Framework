package test;


import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] config = new String[]{"config.xml"}; // xml파일을 config 배열에 담는다
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config); // 컨테이너 생성하여 config 배열을 인자로 갖고
		// 객체를 생성하여 메모리 pool에 넣는다.
		
	/*	SayHello s = (SayHello)context.getBean("myBean"); // mybean 객체를 가져온다. object타입이므로 다운 캐스팅을 한다. 
		s.printMsg();
*/
		PropTest s = (PropTest) context.getBean("PropTest");
		s.printInfo();
	}

}
