package java_200;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aop.Profiler;
import junittest.AService;
import junittest.Acontroller;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@WebAppConfiguration
public class aoptest {
	
	@Autowired
	AService aService;
	
	@Autowired
	Acontroller a;
	
	@Inject
	ApplicationContext applicationContext;
	
	@Test
	public void testt() throws Exception {
		
		System.out.println(applicationContext.getBean(Profiler.class));
		a.testa("Asdf");
		a.testa("test check ok");
		aService.aopTest("테스트");
		System.out.println("확인");
	}
}
