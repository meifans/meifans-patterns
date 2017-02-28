package github.meifans.hello;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.net.URLClassLoader;

@SpringBootApplication
@Slf4j
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    ClassLoader systemloader = ClassLoader.getSystemClassLoader();
    for (URL url : ((URLClassLoader) systemloader).getURLs()) {
      log.info(url.getFile());

    }

  }
}
