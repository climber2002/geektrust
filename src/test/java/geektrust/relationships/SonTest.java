package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SonTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship son = new Son(familyTree);

  @Test
  public void testGetNames_hasSon() {
    assertArrayEquals(new String[] { "Bill", "Charlie", "Percy", "Ronald" }, son.getNames("Margret").toArray(new String[0]));
  }

  @Test
  public void testGetNames_noChildren() {
    assertTrue(son.getNames("Charlie").isEmpty());
  }

  @Test
  public void testGetNames_onlyDaughters() {
    assertTrue(son.getNames("Audrey").isEmpty());
  }
}
