package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import junittest.AService;

@Component
@Aspect
public class Profiler {
	
	
	@Around("execution(* junittest.AService.*(..))")
//	@Around("@annotation(logExecution)")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString+"시작");
		long start = System.currentTimeMillis();
		StopWatch stopWatch = new StopWatch();
		try {
			stopWatch.start("스타트 확인");
			Object re = joinPoint.proceed();
			stopWatch.stop();
			System.out.println(stopWatch.prettyPrint());
			return re;
		}finally{
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "종료");
			System.out.println(signatureString+"실행시간 : "+ (finish-start)+"ms");
		}
	}
}
