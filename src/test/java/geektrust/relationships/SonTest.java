package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SonTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private AbstractRelationship son;

  @Test
  public void testGetNames_hasSon() {
    this.son = new Son("Margret", familyTree);
    assertArrayEquals(new String[] { "Bill", "Charlie", "Percy", "Ronald" }, son.getNames().toArray(new String[0]));
  }

  @Test
  public void testGetNames_noChildren() {
    this.son = new Son("Charlie", familyTree);
    assertTrue(son.getNames().isEmpty());
  }

  @Test
  public void testGetNames_onlyDaughters() {
    this.son = new Son("Audrey", familyTree);
    assertTrue(son.getNames().isEmpty());
  }
}
