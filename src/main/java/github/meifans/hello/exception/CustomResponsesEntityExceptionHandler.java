package github.meifans.hello.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import github.meifans.hello.api.rest.MyRestController;

/**
 * define a @ControllerAdvice to customize the JSON doucument to return a
 * particular controller and or exception type
 * 
 * if {MyException} is thrown by a controller defined in the same package as
 * FooController, a json representation of the CustomerErrorType POJO will be
 * used instead of the ErrorAttributes representation.
 * 
 * @author Administrator
 *
 */

@ControllerAdvice(basePackageClasses = MyRestController.class) // 指定 类所在的包 的范围
public class CustomResponsesEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyException.class) // handler specifital exception
    @ResponseBody
    ResponseEntity<?> halderControllerException(HttpServletRequest request, Throwable ex) {
        return null;

    }

}
