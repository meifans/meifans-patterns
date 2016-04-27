package github.meifans.hello.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // have a Spring application context
@ContextConfiguration(classes = DemoConfiguration.class) // load configuration
public class DemoAnnotationTest {

    @Autowired
    private DemoAnnotation demoAnnotation;

    @Test
    public void demoNotNull() {
        assertNotNull(demoAnnotation);
    }

}
