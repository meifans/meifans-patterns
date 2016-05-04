package github.meifans.hello.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
                .password("admin").roles("admin", "AMIND");

    }

    // @Bean
    // public FilterSecurityInterceptor filterSecurityInterceptor() {
    // return new FilterSecurityInterceptor();
    // }
    //
    // @Bean
    // public UsernamePasswordAuthenticationFilter authenticationFilter() {
    // UsernamePasswordAuthenticationFilter authenticationFilter = new
    // UsernamePasswordAuthenticationFilter();
    // return authenticationFilter;
    // }
}
