package github.meifans.hello.JDK;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Meifans on 17/1/22.
 */
@Slf4j
public class Class {

  @Test
  public void test_isAssignableFrom() {
    TestClass clazz = new TestClass();
    SubTestClass subClazz = new SubTestClass();
    Assert.assertTrue(clazz.getClass().isAssignableFrom(subClazz.getClass()));
  }

  @Test
  public void test_ClassPath() {
    ClassLoader systemloader = ClassLoader.getSystemClassLoader();
    for (URL url : ((URLClassLoader) systemloader).getURLs()) {
      log.info(url.getFile());
    }
  }

  static class TestClass {
  }

  static class SubTestClass extends TestClass {
  }


}
