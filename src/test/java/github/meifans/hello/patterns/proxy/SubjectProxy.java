package github.meifans.hello.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Meifans on 2016/9/6.
 */
public class SubjectProxy implements InvocationHandler {

	private Subject instance;

	public SubjectProxy(Subject subject) {
		instance = subject;
	}


	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		//		ClassLoader loader = instance.getClass().getClassLoader();
		//		if (Modifier.isPublic(method.getModifiers())) {
		//
		//			Proxy.newProxyInstance();
		//		}
		System.out.println("before invoke ");
		return method.invoke(instance, args);

	}
}
