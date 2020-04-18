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
  public void testGetNameOfRelationships_hasMaternalAunt() {
    assertArrayEquals(new String[] { "Dominique" },
      maternalAunt.getNameOfRelationships("Remus").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_noMother() {
    assertTrue(maternalAunt.getNameOfRelationships("Margret").isEmpty());
  }

  @Test
  public void testGetNameOfRelationships_motherHasNoSisters() {
    assertTrue(maternalAunt.getNameOfRelationships("Louis").isEmpty());
  }
}
