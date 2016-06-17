package addr;

import java.util.ArrayList;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] config = new String[]{"config.xml"};
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
		Service service = (Service) context.getBean("addrService");
		service.addMember(new Member(0, "aaa", "111", "asdfs"));
		service.addMember(new Member(0, "bbb", "222", "qwer"));
		service.addMember(new Member(0, "ddd", "444", "wer45"));
		ArrayList<Member> list = (ArrayList<Member>) service.getMembers();
		System.out.println(list);
		System.out.println("1번"+ service.getMember(1));
		System.out.println("2번"+ service.getMember(2));
		System.out.println("3번"+ service.getMember(3));
		service.editMember(new Member(1, "수정qqq", "1234", "5678"));
		list = (ArrayList<Member>) service.getMembers();
		System.out.println(list);
		service.delMember(2);
		list = (ArrayList<Member>) service.getMembers();
		System.out.println(list);
		
	}
}
