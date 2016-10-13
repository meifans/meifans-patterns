package github.meifans.hello.proxy;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Meifans on 2016/9/6.
 */
public class SubjectProxyTest {

	@Test
	public void testRequest() {
		Subject subject = new MusicSubject();
		InvocationHandler handler = new SubjectProxy(subject);
		ClassLoader loader = subject.getClass().getClassLoader();
		Subject proxy = (Subject) Proxy.newProxyInstance(loader, subject.getClass().getInterfaces(), handler);
		proxy.request();
		subject.request();
		System.out.println("interface:" + proxy.getClass().getInterfaces());
		System.out.println("super: " + proxy.getClass().getSuperclass());
		System.out.println("simple name :" + proxy.getClass().getCanonicalName());

		Assert.assertNotNull(proxy);

		Assert.assertEquals(proxy, subject);

	}
}
