package github.meifans.patterns.aspect;

/**
 * Created by Meifans on 2016/8/9.
 */

public class Demo implements DemoInterface {

  public static void main(String[] args) {
    DemoInterface result = (DemoInterface) new DynamicProxy().bindProxy(new Demo());
    result.sayHello();
  }

  public void sayHello() {
    System.out.println("hello!");
  }
}
