package geektrust;

import geektrust.commands.Command;
import geektrust.commands.CommandBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Geektrust {
  private static FamilyTree familyTree = new FamilyTreeBuilder().build();
  private static CommandBuilder commandBuilder = new CommandBuilder();

  public static void main(String[] args) {
    if(args.length < 1) {
      System.out.println("Usage: java -jar geektrust.jar <path_to_input_file> ");
      return;
    }

    String inputFile = args[0];
    try (Stream<String> stream = Files.lines(Paths.get(inputFile))) {
      stream.forEach(Geektrust::executeCommandLine);
    } catch (IOException e) {
      System.out.println("Error reading the input file");
    }
  }

  private static void executeCommandLine(String line) {
    try {
      Command command = commandBuilder.buildCommand(line);
      String commandResult = command.execute(familyTree);
      System.out.println(commandResult);
    } catch (IllegalArgumentException ex) {
      System.out.println("INVALID_COMMAND");
    }
  }
}
