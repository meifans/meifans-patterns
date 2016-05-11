package github.meifan.hello.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpSession;

@Configuration
public class TestConfiguration {

    @Bean
    public MockHttpSession mockSession() {
        return new MockHttpSession();
    }

}
