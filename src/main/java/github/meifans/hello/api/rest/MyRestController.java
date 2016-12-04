package github.meifans.hello.api.rest;

import github.meifans.hello.exception.LocalControllerException;
import github.meifans.hello.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class MyRestController {
    @GetMapping(value = "/hello/{user}")
    public String getUser(@PathVariable String user) {
        return "hello," + user;
    }

    @GetMapping(value = "/exception/{exceptionName}")
    public String testControllerAdvice(@PathVariable String exceptionName) {
        throw new MyException();
    }

    @GetMapping(value = "/exception/local")
    public String testLocalHandlerException() {
        throw new LocalControllerException();
    }

    @ExceptionHandler(LocalControllerException.class)
    public ResponseEntity handleLocalException(LocalControllerException ex) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/test/restTemplate")
    public void testTemplate(@RequestBody TestPost body) {
        log.info(body.getTitle());
    }


}

