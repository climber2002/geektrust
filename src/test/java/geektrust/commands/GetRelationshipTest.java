package geektrust.commands;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetRelationshipTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();
  private Command getRelationship;

  @Test
  public void testExecute_relationshipExists() {
    getRelationship = new GetRelationship("Lily", "Sister-In-Law");
    assertEquals("Darcy Alice", getRelationship.execute(familyTree));
  }

  @Test
  public void testExecute_relationshipNotExists() {
    getRelationship = new GetRelationship("Remus", "Siblings");
    assertEquals("NONE", getRelationship.execute(familyTree));
  }

  @Test
  public void testExecute_personNotFound() {
    getRelationship = new GetRelationship("Luna", "Maternal-Aunt");
    assertEquals("PERSON_NOT_FOUND", getRelationship.execute(familyTree));
  }

  @Test
  public void testExecute_unrecognisableRelationship() {
    getRelationship = new GetRelationship("Remus", "Grandpa");
    assertEquals("INVALID_COMMAND", getRelationship.execute(familyTree));
  }
}
