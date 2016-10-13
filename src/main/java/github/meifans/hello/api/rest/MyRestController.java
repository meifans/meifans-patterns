package github.meifans.hello.api.rest;

import github.meifans.hello.exception.MyException;
import github.meifans.hello.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class MyRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyRestController.class);

	@Autowired
	private DemoService service;

	@RequestMapping(value = "/hello/{user}",
			method = RequestMethod.GET)
	public String getUser(@PathVariable String user) {

		return "hello," + user;

	}

	@RequestMapping(value = "/exception/{exceptionName}",
			method = RequestMethod.GET)
	public String getUser1(@PathVariable String exceptionName) {
		LOGGER.info("exceptionName is :" + exceptionName);
		throw new MyException();

	}

	@RequestMapping(value = "/redis/{user}",
			method = RequestMethod.GET)
	public String login(@PathVariable String user, HttpSession session, ServletRequest request,
			ServletResponse response) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		session.setAttribute(user, user + " want to play a game");
		LOGGER.info("URL:" + "{" + httpRequest.getRequestURL() + "}");
		LOGGER.info("URI:" + "{" + httpRequest.getRequestURI() + "}");
		LOGGER.info("x-auth-token:" + "{" + httpResponse.getHeader("x-auth-token") + "}");

		return user;

	}

}
