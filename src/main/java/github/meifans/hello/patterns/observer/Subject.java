package github.meifans.hello.patterns.observer;

import java.util.Observable;

/**
 * Created by Meifans on 2016/10/24.
 */
public class Subject extends Observable {


    @Override
    public synchronized void setChanged() {
        super.setChanged();
    }
}
