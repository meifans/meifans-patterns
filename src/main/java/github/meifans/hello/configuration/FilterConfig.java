
package github.meifans.hello.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import github.meifans.hello.filter.AuthenticationFilter;

@Configuration
public class FilterConfig implements WebApplicationInitializer {

    /**
     * add filter for Servlet not special DispatcherServlet
     * 
     * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter",
                AuthenticationFilter.class);
        filter.addMappingForUrlPatterns(null, false, "/custom/*");

    }

    /**
     * the second method to add filter to apecial servlet of DispatcherServlet.
     * but there are batch to implements ,but really usrful only one method.
     * 
     * @author meifans
     *
     */
    public class FilterCofigSecond extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return null;
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return null;
        }

        @Override
        protected String[] getServletMappings() {
            return null;
        }

        @Override
        protected Filter[] getServletFilters() {
            return super.getServletFilters();
        }

    }

    /**
     * @return
     */
    @Bean
    public FilterRegistrationBean ThirdMethodAddFilterWithBoot() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(new AuthenticationFilter());

        // dispatcher type ，defult three forward，include，request.
        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));

        registration.addUrlPatterns("/project");

        return registration;

    }

}
