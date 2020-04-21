package java_200;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aop.Profiler;
import config.ServletConfiguration;
import junittest.AService;
import junittest.Acontroller;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServletConfiguration.class})
@WebAppConfiguration
public class aoptest {
	
	@Autowired
	AService aService;
	
	@Autowired
	Acontroller a;
	
	@Inject
	ApplicationContext applicationContext;
	
	@Autowired
	private Environment environment;
	
	@Test
	public void testt() throws Exception {
		a.testa("확인");
	}
}
