package junittest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import aop.logExecution;

@Component
public class AServiceImpl implements AService{

	@logExecution
	@Override
	public String aopTest(String a) throws Exception {
		System.out.println("테스트"+a);
		return a;
	}
}
