package github.meifans.patterns.command;

import java.util.LinkedList;

/**
 * Created by Meifans on 2016/11/17.
 */
public class ActiveObjectEngine {

  private LinkedList<Command> commands = new LinkedList<>();

  public void run() {
    while (!commands.isEmpty()) {
      Command c = commands.getFirst();
      commands.removeFirst();
      c.execute();
    }
  }

  public void addCommand(Command command) {
    commands.add(command);
  }

}
