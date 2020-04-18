package geektrust.commands;

public class CommandBuilder {
  public Command buildCommand(String commandLine) {
    String[] args = commandLine.split(" ");
    Command command = null;
    switch (args[0]) {
      case "ADD_CHILD":
        command = new AddChild(args[1], args[2], args[3]);
        break;
      case "GET_RELATIONSHIP":
        command = new GetRelationship(args[1], args[2]);
        break;
      default:
        throw new IllegalArgumentException(String.format("Unknown Command: %s", commandLine));
    }
    return command;
  }
}
