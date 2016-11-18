package github.meifans.hello.patterns.command;

/**
 * Created by Meifans on 2016/11/18.
 */
public class DelayedTyper implements Command {

	private static ActiveObjectEngine engine = new ActiveObjectEngine();
	private static boolean stop = false;
	private long delay;
	private char id;

	public DelayedTyper(long delayTime, char commandId) {
		delay = delayTime;
		id = commandId;
	}

	public static void main(String[] args) {
		engine.addCommand(new DelayedTyper(100, '1'));
		engine.addCommand(new DelayedTyper(300, '3'));
		engine.addCommand(new DelayedTyper(500, '5'));
		engine.addCommand(new DelayedTyper(700, '7'));

		Command stopCommand = () -> stop = true;
		engine.addCommand(new SleepCommand(2000,engine,stopCommand));
		//engine.addCommand(stopCommand);
		engine.run();

	}

	public void execute() {
		System.out.print(id);
		if (!stop) {
			delayAndRepeat();
		}
	}

	private void delayAndRepeat() {
		engine.addCommand(new SleepCommand(delay, engine, this));
	}

}
