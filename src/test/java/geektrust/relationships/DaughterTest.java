package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DaughterTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship daughter = new Daughter(familyTree);

  @Test
  public void testGetNames_hasDaughter() {
    assertArrayEquals(new String[] { "Ginerva" }, daughter.getNames("Margret").toArray(new String[0]));
  }

  @Test
  public void testGetNames_noChildren() {
    assertTrue(daughter.getNames("Charlie").isEmpty());
  }

  @Test
  public void testGetNames_noDaughters() {
    assertTrue(daughter.getNames("Ted").isEmpty());
  }
}
