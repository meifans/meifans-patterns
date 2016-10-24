package github.meifans.hello.patterns.observer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Meifans on 2016/10/24.
 */
public class ObserverTest {

    private Observer observer;

    private Subject subject;

    @Before
    public void newInstance() {
        observer = new Observer();
        subject = new Subject();
    }

    @Test
    public void test_update() {
        subject.addObserver(observer);
        subject.setChanged();
        subject.notifyObservers();
        Assert.assertTrue(observer.informed);
        Assert.assertTrue(subject == observer.subject);
    }
}
