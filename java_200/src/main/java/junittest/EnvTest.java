package junittest;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import config.Propertyconfig;
import config.ServletConfiguration;
import config.configuation;

public class EnvTest {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext();
		
		ConfigurableEnvironment env = context.getEnvironment();
//		String javaVersion = env.getProperty("java.version");
//		System.out.println(javaVersion);
//		System.out.println(env.getRequiredProperty("java.version"));
		
		MutablePropertySources propertySource = env.getPropertySources();
		try {
			propertySource.addLast(new ResourcePropertySource("classpath:db.properties"));
			String dbUser = env.getProperty("db.user");
			System.out.println(dbUser);
			System.out.println(env.getProperty("db.password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AnnotationConfigApplicationContext gctx = (AnnotationConfigApplicationContext) context;
		gctx.register(configuation.class);
		gctx.register(Propertyconfig.class);
		gctx.refresh();
		ConnectionProvider gctx1 = gctx.getBean(ConnectionProvider.class);
		ConnectionProvider2 gctx2 = gctx.getBean(ConnectionProvider2.class);
		System.out.println(gctx1.getDriver());
		System.out.println(gctx1.getPassword());
		System.out.println(gctx1.getUrl());
		System.out.println(gctx1.getUser());
		
		System.out.println("=============== 애노테이션을 이용해 프로퍼티 설정 ====================");
		System.out.println(gctx2.getDriver());
		System.out.println(gctx2.getPassword());
		System.out.println(gctx2.getUrl());
		System.out.println(gctx2.getUser());
		
		context.close();
	}
}
