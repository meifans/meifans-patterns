package github.meifan.hello.api.rest;

import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Meifans on 2016/10/15.
 */
@RunWith(SpringRunner.class)

public class MyRestControllerTest {


    @Test
    public void testRestController() {
        RequestBody body = new RequestBody();
        body.setBizid("d");
        body.setFinanceId("djfs");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.postForObject(
                "localhost:8080/taskcenter/taskFinish", entity, ResponseEntity.class);
    }

    @Data
    class RequestBody {
        private String bizid;
        private String financeId;
    }

    @Data
    class ResponseEntity {
        private String failReason;
        private boolean success;
    }
}
