package github.meifans.hello.service;

import org.junit.Before;
import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Meifans on 2016/10/21.
 */
public class SampleStreamTest {


  List<String> record;

  @Before
  public void prepare() {
    record = new ArrayList<>();
    record.add("Yu");
    record.add("si");
    record.add("yu");
  }

  @Test
  public void streamTest() {
    String[] strings = {"", " "};
    for (String s : strings) {
      System.out.println(s);
    }
    Demo d = new Demo();
    for (String s : d) {

    }

  }

  private Person map(String s) {
    return new Person(s);
  }

  public boolean matchFirst(String s) {
    Supplier<Runnable> ss = () -> () -> System.out.println("go");
    Function<?, Runnable> ff = (String sb) -> {
      System.out.println("g");
      return () -> System.out.println("gogo");
    };
    Set<String> si = Collections.<String>emptySet();
    Set is = Collections.emptySet();
    Person<ArrayList> b = new Person<>(null);
//        Person<List> bb = new Person<List>(null);

    return s.equals("Yu");
  }

  class Person<T extends AbstractList> {
    String name;
    int old;
    String place;

    public Person(String name) {
      this.name = name;
    }
  }

  class Demo implements Iterable<String> {

    @Override
    public Iterator<String> iterator() {
      return null;
    }
  }
}
