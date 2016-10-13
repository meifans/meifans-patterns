package github.meifans.hello.configuration;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * <!-- <dependency> <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-redis</artifactId> </dependency> -->
 * 这个依赖会自动开启配置redis
 */

// @EnableRedisHttpSession // SessionRepositoryFilter ... to add session in
// redis
public class RedisConfig extends CachingConfigurerSupport {

//	@Bean
//	public JedisConnectionFactory connectionFactory() {
//
//		JedisConnectionFactory connection = new JedisConnectionFactory();
//
//		// not wirte,then is localhost and 6379
//		// connection.setPort(properties.getPort());
//		// connection.setHostName(properties.getHost());// to modify
//		// connection.setPassword(properties.getPassword());
//
//		return connection;
//	}

	// We customize Spring Session’s HttpSession integration to use HTTP headers
	// to convey the current session information instead of cookies.
	// @Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}

}
