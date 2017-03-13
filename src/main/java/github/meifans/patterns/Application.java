package github.meifans.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by Meifans on 17/3/3.
 */
@SpringBootApplication
public class Application {


  public static void main(String args) {
    final ApplicationContext ctx = SpringApplication.run(Application.class, args);
  }
}
