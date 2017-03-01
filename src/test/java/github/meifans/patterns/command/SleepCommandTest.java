package github.meifans.patterns.command;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Meifans on 2016/11/17.
 */
@Slf4j
public class SleepCommandTest {

	boolean commandExecuted;

	@Before
	public void prepare() {
		commandExecuted = false;
	}

	@Test
	public void testSleep() {
		Command wakeup = () -> commandExecuted = true;
		ActiveObjectEngine engine = new ActiveObjectEngine();
		SleepCommand sleepCommand = new SleepCommand(1000, engine, wakeup);
		engine.addCommand(sleepCommand);

		long currentTime = System.currentTimeMillis();
		engine.run();
		long sleepTime = System.currentTimeMillis() - currentTime;
		log.info("" + sleepTime);

		Assert.assertTrue(sleepTime >= 1000 && sleepTime < 1100);
		Assert.assertTrue(commandExecuted);
	}
}
