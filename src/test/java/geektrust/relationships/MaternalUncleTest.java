package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaternalUncleTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship maternalUncle = new MaternalUncle(familyTree);

  @Test
  public void testGetNames_hasMaternalUncle() {
    assertArrayEquals(new String[] { "Bill", "Charlie", "Percy", "Ronald" },
      maternalUncle.getNames("James").toArray(new String[0]));
  }

  @Test
  public void testGetNames_noMother() {
    assertTrue(maternalUncle.getNames("Margret").isEmpty());
  }

  @Test
  public void testGetNames_motherHasNoBrother() {
    assertTrue(maternalUncle.getNames("Louis").isEmpty());
  }
}
