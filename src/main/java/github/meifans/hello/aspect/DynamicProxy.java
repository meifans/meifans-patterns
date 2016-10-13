package github.meifans.hello.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Meifans on 2016/8/9.
 */
public class DynamicProxy implements InvocationHandler {

	private Object target;

	@Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("do something before method");
		Object result = method.invoke(target, args);
		System.out.println("do something after method");
		return result;
	}

	public Object bindProxy(Object object){
		target=object;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
}
