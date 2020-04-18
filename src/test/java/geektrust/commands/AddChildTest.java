package geektrust.commands;

import geektrust.FamilyMember;
import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static geektrust.Gender.FEMALE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AddChildTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();
  private Command addChild;

  @Test
  public void testExecute() {
    addChild = new AddChild("Flora", "Minerva", "Female");
    assertEquals("CHILD_ADDITION_SUCCEEDED", addChild.execute(familyTree));

    FamilyMember child = familyTree.getFamilyMember("Minerva");
    assertEquals(FEMALE, child.getGender());
    assertEquals("Flora", child.getMother().get().getName());
  }

  @Test
  public void testExecute_personNotFound() {
    addChild = new AddChild("Luna", "Lola", "Female");
    assertEquals("PERSON_NOT_FOUND", addChild.execute(familyTree));
    assertFalse(familyTree.hasFamilyMember("Lola"));
  }

  @Test
  public void testExecute_addToFather() {
    addChild = new AddChild("Ted", "Bella", "Female");
    assertEquals("CHILD_ADDITION_FAILED", addChild.execute(familyTree));
    assertFalse(familyTree.hasFamilyMember("Bella"));
  }

  @Test
  public void testExecute_invalidGender() {
    addChild = new AddChild("Flora", "Minerva", "Unknown");
    assertEquals("INVALID_COMMAND", addChild.execute(familyTree));
  }
}
