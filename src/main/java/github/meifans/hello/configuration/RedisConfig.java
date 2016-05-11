package github.meifans.hello.configuration;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

//@EnableRedisHttpSession // SessionRepositoryFilter ... to add session in redis
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public JedisConnectionFactory connectionFactory() {

        JedisConnectionFactory connection = new JedisConnectionFactory();
        // not wirte,then is localhost and 6379
        // connection.setPort(properties.getPort());
        // connection.setHostName(properties.getHost());// to modify
        // connection.setPassword(properties.getPassword());

        return connection;
    }

    // @Bean
    // public DelegatingFilterProxy delegatingFilterProxy() {
    // return new DelegatingFilterProxy();
    // }
    //
    // @Bean
    // public FilterRegistrationBean ThirdMethodAddFilterWithBoot() {
    // FilterRegistrationBean registration = new FilterRegistrationBean();
    // registration.setFilter(delegatingFilterProxy());
    // registration.addUrlPatterns("/*");
    // return registration;
    //
    // }

    // We customize Spring Session’s HttpSession integration to use HTTP headers
    // to convey the current session information instead of cookies.
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }

    // @Bean // user boot embeddedRedisServer
    // public RedisServer redisServer() throws IOException {
    // return new RedisServer(properties.getHost(), properties.getPort());
    // }
}
