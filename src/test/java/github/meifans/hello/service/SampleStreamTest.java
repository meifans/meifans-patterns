package github.meifans.hello.service;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public static boolean matchFirst(String s) {

        return s.equals("Yu");
    }

    class Person {
        String name;
        int old;
        String place;

        public Person(String name) {
            this.name = name;
        }
    }

    class Demo implements Iterable<String>{

        @Override
        public Iterator<String> iterator() {
            return null;
        }
    }
}
