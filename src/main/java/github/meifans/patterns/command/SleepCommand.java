package github.meifans.patterns.command;

/**
 * Created by Meifans on 2016/11/17.
 */
public class SleepCommand implements Command {

	private ActiveObjectEngine engine;
	private Command wakeupCommand;
	private long sleepTime;
	private long startTime;
	private boolean started = false;

	public SleepCommand(long millisecond, ActiveObjectEngine e, Command command) {
		sleepTime = millisecond;
		engine = e;
		wakeupCommand = command;
	}

	public void execute() {
		long currentTime = System.currentTimeMillis();
		if (!started) {
			started = true;
			startTime = currentTime;
			engine.addCommand(this);
		} else if (currentTime - startTime < sleepTime) {
			engine.addCommand(this);
		} else {
			engine.addCommand(wakeupCommand);
		}
	}

}
