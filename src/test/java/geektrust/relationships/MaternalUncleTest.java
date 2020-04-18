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
  public void testGetNameOfRelationships_hasMaternalUncle() {
    assertArrayEquals(new String[] { "Bill", "Charlie", "Percy", "Ronald" },
      maternalUncle.getNameOfRelationships("James").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_noMother() {
    assertTrue(maternalUncle.getNameOfRelationships("Margret").isEmpty());
  }

  @Test
  public void testGetNameOfRelationships_motherHasNoBrother() {
    assertTrue(maternalUncle.getNameOfRelationships("Louis").isEmpty());
  }
}
