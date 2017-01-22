package github.meifans.hello;

import org.joda.time.DateTime;

import java.util.TimeZone;

//@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    //SpringApplication.run(Application.class, args);
    System.out.println("DateTime.now.toString:" + DateTime.now().toString());
    System.out.println("time.zone:" + System.getProperty("user.timezone"));
    System.out.println("TimeZone.getDefault:" + TimeZone.getDefault());
  }
}
