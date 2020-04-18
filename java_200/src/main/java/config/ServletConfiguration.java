package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import NaverLogin.NaverLoginBO;
import aop.Profiler;

@Configuration
@EnableWebMvc
@ComponentScan({"config","NaverLogin","junittest","aop"})
@EnableAspectJAutoProxy
public class ServletConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolve() {
		InternalResourceViewResolver resolve = new InternalResourceViewResolver();
		resolve.setViewClass(JstlView.class);
		resolve.setPrefix("/WEB-INF/views/");
		resolve.setSuffix(".jsp");
		return resolve;
	}
	
	@Bean
	public NaverLoginBO naverLoginBO() {
		NaverLoginBO login = new NaverLoginBO();
		return login;
	}
	@Bean
	public Profiler profiler() {
		Profiler profiler = new Profiler();
		return profiler;
	}
	
	
	
}
