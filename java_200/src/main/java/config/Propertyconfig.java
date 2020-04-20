package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import junittest.ConnectionProvider2;

@Configuration
public class Propertyconfig {

	@Value("${db.driver}")
	private String driver;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	@Value("${db.jdbcUrl}")
	private String url;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer pro() {
		PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
		config.setLocation(new ClassPathResource("db.properties"));
		return config;
	}
	
	@Bean
	public ConnectionProvider2 connection(){
		ConnectionProvider2 con = new ConnectionProvider2();
		con.setDriver(driver);
		con.setPassword(password);
		con.setUrl(url);
		con.setUser(user);
		return con;
	}
}
