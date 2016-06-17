package myAdvice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ProfilingAdvice {
	public void printStr(JoinPoint joinPoint, Object ret) throws Throwable {
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "--advice" + (String)ret);
	}
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureString  = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "����" );
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed(); // ��� method�� ȣ��
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ����");
			System.out.println(signatureString + " ���� �ð� : " + 
					(finish - start) + "ms");
		}
	}
}
