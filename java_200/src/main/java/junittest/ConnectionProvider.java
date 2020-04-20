package junittest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ConnectionProvider {

	@Autowired
	private Environment env;
	
	private String driver;
	private String user;
	private String password;
	private String url;
	
	public void init() {
		driver = env.getProperty("db.driver");
		user = env.getProperty("db.user");
		password = env.getProperty("db.password");
		url = env.getProperty("db.jdbcUrl");
	}
	
	 public String getDriver() {
		 return driver;
	 }
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public String getUrl() {
		return url;
	}
	 
	 
//	 @Override
//	public void afterPropertiesSet() throws Exception {
//		 System.out.println("afterPropertiesSet");
//		 setDriver(env.getProperty("db.driver"));
//	}
}
