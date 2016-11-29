package github.meifans.hello.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Meifans on 2016/11/29.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Autowired
    private Environment environment;

    @Bean
    public WebMvcConfigurer swaggerUi() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers(final ResourceHandlerRegistry registry) {
                registry.addResourceHandler("swagger-ui.html")
                        .addResourceLocations("classpath:/META-INF/resources/");
            }
        };
    }
}
