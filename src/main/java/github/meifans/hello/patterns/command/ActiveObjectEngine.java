package github.meifans.hello.patterns.command;

import java.util.LinkedList;

/**
 * Created by Meifans on 2016/11/17.
 */
public class ActiveObjectEngine {

	LinkedList<Command> commands = new LinkedList<>();

	public void addCommand(Command c){
		commands.add(c);
	}

	public void run() {
		while (!commands.isEmpty()) {
			Command c = commands.getFirst();
			commands.removeFirst();
			c.execute();
		}
	}


}
