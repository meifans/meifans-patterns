package github.meifans.hello.api.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import github.meifans.hello.exception.MyException;

@RestController
@RequestMapping("/")
public class MyRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyRestController.class);

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public String getUser(@PathVariable String user) {
        return "hello," + user;

    }

    @RequestMapping(value = "/exception/{exceptionName}", method = RequestMethod.GET)
    public String getUser1(@PathVariable String exceptionName) {
        LOGGER.info("exceptionName is :" + exceptionName);
        throw new MyException();

    }

}
