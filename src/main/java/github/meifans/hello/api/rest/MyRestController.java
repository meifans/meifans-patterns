package github.meifans.hello.api.rest;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyRestController {

    @RequestMapping(value = "/{meifans}", method = RequestMethod.GET)
    public String getUser(@PathVariable String user) {
        return "hello," + user;

    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String getUser1(@PathVariable String exceptionName) {
        throw new ConversionNotSupportedException(null, null, null);

    }

}
