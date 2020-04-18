package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaternalAuntTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship maternalAunt = new MaternalAunt(familyTree);

  @Test
  public void testGetNames_hasMaternalAunt() {
    assertArrayEquals(new String[] { "Dominique" },
      maternalAunt.getNames("Remus").toArray(new String[0]));
  }

  @Test
  public void testGetNames_noMother() {
    assertTrue(maternalAunt.getNames("Margret").isEmpty());
  }

  @Test
  public void testGetNames_motherHasNoSisters() {
    assertTrue(maternalAunt.getNames("Louis").isEmpty());
  }
}
