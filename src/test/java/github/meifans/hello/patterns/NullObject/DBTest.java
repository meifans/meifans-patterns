package github.meifans.hello.patterns.NullObject;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by Meifans on 16/12/15.
 */
public class DBTest {

    @Test
    public void testNull() {
        Employee employee = DB.getEmployee("meifans");
        if (employee.timeToPay(new Date())) {
            employee.pay();
        }
        Assert.assertEquals(Employee.NULL, employee);
    }

    public static <T> T test(Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("", null, clazz);

    }

}