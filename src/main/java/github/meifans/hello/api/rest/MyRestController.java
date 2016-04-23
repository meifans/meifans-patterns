package github.meifans.hello.api.rest;

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

}
