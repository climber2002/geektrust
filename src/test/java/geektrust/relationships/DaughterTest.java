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
  public void testGetNameOfRelationships_hasDaughter() {
    assertArrayEquals(new String[] { "Ginerva" },
      daughter.getNameOfRelationships("Margret").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_noChildren() {
    assertTrue(daughter.getNameOfRelationships("Charlie").isEmpty());
  }

  @Test
  public void testGetNameOfRelationships_noDaughters() {
    assertTrue(daughter.getNameOfRelationships("Ted").isEmpty());
  }
}
