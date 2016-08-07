package github.meifans.hello.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import github.meifan.hello.configuration.TestConfiguration;
import github.meifans.hello.Application;

@RunWith(SpringJUnit4ClassRunner.class) // have a Spring application context
@ActiveProfiles("test") // read application-test.properties
// @ContextConfiguration(classes = DemoConfiguration.class)
// load configuration ,but up to now ,can't work

// @ConfigurationProperties(prefix = "meifans.helloworld")

@SpringApplicationConfiguration(classes = {Application.class, TestConfiguration.class}) //
// 加载springboot ,TestConfiguration是为了引入mock的bean。

/**
 * 1、{@SpringApplicationConfiguration(classes = {Application.class})} 和
 * {@ContextConfiguration(classes =DemoConfiguration.class)} 单独存在，
 * 都可以得到demoAnnotation bean.不同的是，springboot不需要类{DemoConfiguration.class}的
 * {@ComponentScan}注解， 而
 * {@ContextConfiguration(classes =DemoConfiguration.class)}，需要
 * 
 * {@ComponentScan指明要扫描这个类所在的包里的bean} 2、@ActiveProfiles("test")和
 * {@SpringApplicationConfiguration(classes = {Application.class})}还有
 * {@RunWith(SpringJUnit4ClassRunner.class)}一起工作，可以完成bean的注入功能，和注入@Value("${meifans.helloworld.name}") 的功能
 * 若要单独完成bean注入功能，只需要后两者就行。 但是把{@SpringApplicationConfiguration(classes =
 * {Application.class})}换成{@ContextConfiguration(classes =
 * DemoConfiguration.class)} ，只能完成注入bean，无法解析{@Value}
 * 
 * 
 * 
 * 
 * @author meifans
 *
 */
@ConfigurationProperties(prefix = "meifans")
public class DemoAnnotationTest {

    String name;
    private String password;

    @Value("${meifans.helloworld.name}") // origin
    private String rname;

    @Autowired
    private DemoAnnotation demoAnnotation;

    @Autowired
    private MockHttpSession mockSession;

    @Test
    public void demoNotNull() { // test get configuration or get bean
        assertNotNull(demoAnnotation);
    }

    @Test
    public void ConfigurationProperties() {
        assertEquals("grass_stars", name);
        assertEquals("notEasyGoDai", password);
        assertEquals("grass_stars", rname);

    }

}
