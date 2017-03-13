package github.meifans.patterns.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Meifans on 2016/8/9.
 */
@Slf4j
public class DynamicProxy implements InvocationHandler {

  private Object target;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    log.info("do something before method");
    Object result = method.invoke(target, args);
    log.info("do something after method");
    return result;
  }

  public Object bindProxy(Object object) {
    target = object;
    return Proxy.newProxyInstance(target.getClass().getClassLoader(),
        target.getClass().getInterfaces(), this);
  }
}
