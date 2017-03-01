package github.meifans.hello.patterns.proxy;

/**
 * Created by Meifans on 2016/9/6.
 */
public class MusicSubject implements Subject {

	public void request() {
		System.out.println("this is music subject");
	}
}
