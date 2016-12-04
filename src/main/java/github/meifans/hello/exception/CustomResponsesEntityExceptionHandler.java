package github.meifans.hello.exception;

import github.meifans.hello.api.rest.MyRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * define a @ControllerAdvice to customize the JSON doucument to return a
 * particular controller and or exception type
 * <p>
 * if {MyException} is thrown by a controller defined in the same package as
 * FooController, a json representation of the CustomerErrorType POJO will be
 * used instead of the ErrorAttributes representation.
 *
 * @author meifans
 */

@ControllerAdvice(basePackageClasses = MyRestController.class) // 指定 类所在的包 的范围
public class CustomResponsesEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyException.class) // handler specifital exception
    @ResponseBody
    ResponseEntity halderControllerException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity(HttpStatus.OK);
    }

}
