package github.meifans.patterns.aspect;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Meifans on 2016/8/9.
 */
@Slf4j
public class Demo implements DemoInterface {

  public static void main(String[] args) {
    DemoInterface result = (DemoInterface) new DynamicProxy().bindProxy(new Demo());
    result.sayHello();
  }

  public void sayHello() {
    log.info("hello!");
  }
}
