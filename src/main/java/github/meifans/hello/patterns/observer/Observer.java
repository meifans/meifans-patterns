package github.meifans.hello.patterns.observer;

import java.util.Observable;

/**
 * Created by Meifans on 2016/10/24.
 */
public class Observer implements java.util.Observer {

    boolean informed = false;
    Object arg;
    Observable subject;

    @Override
    public void update(Observable o, Object arg) {
        subject = o;
        this.arg = arg;
        informed = true;
        System.out.println("ok,accept the inform");
    }
}
