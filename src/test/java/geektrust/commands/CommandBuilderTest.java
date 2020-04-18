package geektrust.commands;

import geektrust.Couple;
import geektrust.MarryMemberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandBuilderTest {
  private CommandBuilder commandBuilder = new CommandBuilder();

  @Test
  public void testBuild_addChild() {
    AddChild addChild = (AddChild)commandBuilder.buildCommand("ADD_CHILD Flora Minerva Female");
    assertEquals("Flora", addChild.getMotherName());
    assertEquals("Minerva", addChild.getChildName());
    assertEquals("Female", addChild.getChildGenderName());
  }

  @Test
  public void testBuild_getRelationship() {
    GetRelationship getRelationship = (GetRelationship)commandBuilder.buildCommand("GET_RELATIONSHIP Minerva Siblings");
    assertEquals("Minerva", getRelationship.getMemberName());
    assertEquals("Siblings", getRelationship.getRelationshipName());
  }

  @Test
  public void testBuild_unknownCommand() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      commandBuilder.buildCommand("UNKNOWN");
    });
    assertEquals("Unknown Command: UNKNOWN", exception.getMessage());
  }
}
