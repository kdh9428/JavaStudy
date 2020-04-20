package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import junittest.ConnectionProvider;

@Configuration
public class configuation {
	
	@Bean(initMethod = "init")
	public ConnectionProvider connectionProvider() {
		return new ConnectionProvider();
	}
}
